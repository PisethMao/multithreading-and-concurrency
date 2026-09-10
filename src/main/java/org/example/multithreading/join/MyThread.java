package org.example.multithreading.join;

public class MyThread implements Runnable {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("Thread is running, name of the thread is: " + thread.getName());
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("Thread is interrupted" + e.getMessage());
        }
        System.out.println("Thread is ended, name of the thread is: " + thread.getName());
    }
}
