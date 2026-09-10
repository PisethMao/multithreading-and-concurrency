package org.example.multithreading.priority;

public class ThreadPriorityDemo {
    static void main() {
        Thread t1 = new Thread(new SampleThread("Thread 1"));
        Thread t2 = new Thread(new SampleThread("Thread 2"));
        Thread t3 = new Thread(new SampleThread("Thread 3"));
        System.out.println("Thread 1 Priority: " + t1.getPriority());
        System.out.println("Thread 2 Priority: " + t2.getPriority());
        System.out.println("Thread 3 Priority: " + t3.getPriority());
        t1.setPriority(4);
        t2.setPriority(1);
        t3.setPriority(9);
        System.out.println("New Thread 1 Priority: " + t1.getPriority());
        System.out.println("New Thread 2 Priority: " + t2.getPriority());
        System.out.println("New Thread 3 Priority: " + t3.getPriority());
//        t1.start();
//        t2.start();
//        t3.start();
        System.out.println("Currently Running Thread: " + Thread.currentThread().getName());
        System.out.println("Main Thread Priority: " + Thread.currentThread().getPriority());
        t1.setDaemon(true);
        System.out.println("New Thread 1 Priority after making it's daemon: " + t1.getPriority());
        t1.start();
        t2.start();
        t3.start();
    }
}
