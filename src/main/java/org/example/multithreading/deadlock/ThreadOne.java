package org.example.multithreading.deadlock;

public class ThreadOne implements Runnable {
    private final ClassOne classOne;
    private final ClassTwo classTwo;

    public ThreadOne(ClassOne classOne, ClassTwo classTwo) {
        this.classOne = classOne;
        this.classTwo = classTwo;
    }

    @Override
    public void run() {
        synchronized (classOne) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Thread one has got the lock on class one, waiting to get the lock on class two.");
            synchronized (classTwo) {
                System.out.println("Thread one has got the lock on class two.");
            }
        }
    }
}
