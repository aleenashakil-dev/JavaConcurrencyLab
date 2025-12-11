package com.lab7;

public class ConcurrencyApp {
    public static void main(String[] args) throws InterruptedException {

        WorkerTask calcTask = new WorkerTask("Calculator-Thread");
        WorkerTask logTask = new WorkerTask("Logger-Thread");

        Thread t1 = new Thread(calcTask);
        Thread t2 = new Thread(logTask);

        t1.start();

        System.out.println("\nMain: Waiting for Calculator-Thread to finish (using join())...");
        t1.join();
        System.out.println("Main: Calculator finished. Starting Logger-Thread.");

        t2.start();

        Thread.sleep(1000);

        logTask.stopTask();
        System.out.println("Main: Signaled Logger-Thread to stop gracefully.");
    }
}