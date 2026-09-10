package org.example.multithreading;

public class ExtendThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("ExtendThread.run(): " + Thread.currentThread().getName());
    }
}

