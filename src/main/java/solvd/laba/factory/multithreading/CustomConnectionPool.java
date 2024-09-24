package solvd.laba.factory.multithreading;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomConnectionPool {
    private int poolSize;
    private int usedConnections;
    private List<CustomConnection> availableConnectionList;


    public CustomConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        availableConnectionList = new ArrayList<>();
    }

    public CustomConnection getConnection() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (usedConnections < poolSize) {
                    usedConnections++;
                    if (availableConnectionList.isEmpty()) {
                        return new CustomConnectionImpl();
                    } else {
                        return availableConnectionList.remove(0);
                    }
                } else {
                    this.wait();
                }
            }
        }
    }

    public void releaseConnection(CustomConnection connection) {
        synchronized (this) {
            availableConnectionList.add(connection);
            usedConnections--;
            this.notify();
        }
    }

    public void close() {
        availableConnectionList.stream()
                .forEach(CustomConnection::close);
    }
}
