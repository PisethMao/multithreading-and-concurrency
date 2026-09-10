package org.example.multithreading.join;

public class ThreadJoinDemo {
    static void main() {
        Thread t1 = new Thread(new MyThread(), "Thread 1");
        Thread t2 = new Thread(new MyThread(), "Thread 2");
        Thread t3 = new Thread(new MyThread(), "Thread 3");
        t1.start();
        try {
            t1.join();
        }catch (InterruptedException e){
            System.out.println("Thread is interrupted" + e.getMessage());
        }
        t2.start();
        try {
            t2.join();
        }catch (InterruptedException e){
            System.out.println("Thread is interrupted" + e.getMessage());
        }
        t3.start();
        try {
            t3.join();
        }catch (InterruptedException e){
            System.out.println("Thread is interrupted" + e.getMessage());
        }
        System.out.println("All the threads have finished executing!");
    }
}
