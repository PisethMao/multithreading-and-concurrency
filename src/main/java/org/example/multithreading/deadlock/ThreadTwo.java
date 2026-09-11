package org.example.multithreading.deadlock;

public class ThreadTwo implements Runnable {
    private final ClassOne classOne;
    private final ClassTwo classTwo;

    public ThreadTwo(ClassOne classOne, ClassTwo classTwo) {
        this.classOne = classOne;
        this.classTwo = classTwo;
    }

    @Override
    public void run() {
        synchronized (classOne) {
            System.out.println("Thread two has got the lock on class two, waiting to get the lock on class one.");
            synchronized (classTwo) {
                System.out.println("Thread two has got the lock on class one also.");
            }
        }
    }
}
