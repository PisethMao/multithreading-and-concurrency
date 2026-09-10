package org.example.multithreading.priority;

public class SampleThread implements Runnable {
    private final String threadName;

    public SampleThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Main Thread is running: " + threadName);
    }
}
