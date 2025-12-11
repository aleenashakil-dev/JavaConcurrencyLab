package com.lab7;

class WorkerTask implements Runnable {
    private String name;
    private volatile boolean keepRunning = true; 

    public WorkerTask(String name) {
        this.name = name;
    }

    public void stopTask() {
        this.keepRunning = false; 
    }

    @Override
    public void run() {
      
        System.out.println(name + " starting execution."); 
        int counter = 0;
        
        while (keepRunning && counter < 10) { 
            counter++;
            System.out.println(name + ": Executing iteration " + counter);
            try {
              
                Thread.sleep(200); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.out.println(name + " was interrupted. Exiting.");
                return;
            }
        }
        System.out.println(name + " finished execution.");
    }
}