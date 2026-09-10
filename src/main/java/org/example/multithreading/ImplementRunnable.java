package org.example.multithreading;

public class ImplementRunnable implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("ImplementRunnable.run(): " + Thread.currentThread().getName());
        }catch (Exception e){
            System.out.println("ImplementRunnable.run(): " + e.getMessage());
        }
    }
}
