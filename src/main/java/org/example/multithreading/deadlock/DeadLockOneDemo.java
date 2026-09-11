package org.example.multithreading.deadlock;

public class DeadLockOneDemo {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static void main() {
        Thread.ofPlatform().name("Thread-One").start(() -> {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + ": Thread-One has got the lock on object one.");
                sleep(1000);
                System.out.println(Thread.currentThread().getName() + ": Thread-One has waited to get the lock on object two.");
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + ": Thread-One has got the lock on object two.");
                }
            }
        });
        Thread.ofPlatform().name("Thread-Two").start(() -> {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + ": Thread-Two has got the lock on object two.");
                sleep(1000);
                System.out.println(Thread.currentThread().getName() + ": Thread-Two has waited to get the lock on object one.");
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + ": Thread-Two has got the lock on object two.");
                }
            }
        });
    }
}
