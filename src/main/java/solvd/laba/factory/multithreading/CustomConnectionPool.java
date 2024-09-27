package solvd.laba.factory.multithreading;

import javax.inject.Singleton;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Singleton
public class CustomConnectionPool {
    private static CustomConnectionPool connectionPool;
    private int poolSize;
    private int usedConnections;
    private List<CustomConnection> availableConnectionList;


    private CustomConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        availableConnectionList = new ArrayList<>();
    }

    public static CustomConnectionPool getConnectionPool(int poolSize) {
        if (connectionPool == null) {
            connectionPool = new CustomConnectionPool(poolSize);
        }
        return connectionPool;
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
