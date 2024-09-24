package solvd.laba.factory.multithreading;

public class Task implements Runnable{
    private int number;
    private CustomConnectionPool connectionPool;

    public Task(int number, CustomConnectionPool connectionPool) {
        this.number = number;
        this.connectionPool = connectionPool;
    }

    public void run()
    {
        try {
            CustomConnectionImpl connection = (CustomConnectionImpl) connectionPool.getConnection();
            try {
                System.out.println("Began connection on task " + number);
                Thread.sleep(20000);
                System.out.println("Finish connection on task " + number);
            } finally {
                connectionPool.releaseConnection(connection);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}