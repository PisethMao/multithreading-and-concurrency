package org.example.multithreading.threadrunnabledemo;

public class ThreadTwo implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Thread Two run");
        }catch (Exception e){
            System.out.println("Thread Two run error");
        }
    }
}
