package org.example.multithreading.threadrunnabledemo;

public class ThreadOne extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Thread One run");
        }catch (Exception e){
            System.out.println("Thread One run error");
        }
    }
}
