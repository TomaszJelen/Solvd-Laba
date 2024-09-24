package solvd.laba.factory.multithreading;

public class TaskThread extends Thread{
    public TaskThread() {
    }

    public void run()
    {
        System.out.println("Began task in another thread");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished task in another thread");
    }
}