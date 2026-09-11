package org.example.multithreading.synchronization.synchronizedlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemoWithTimeout {
    private static final Lock locker = new ReentrantLock();

    static void main() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            locker.lock();
            try {
                System.out.println("Thread-1 acquired the lock...");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                locker.unlock();
                System.out.println("Thread-1 released the lock.");
            }
        }, "Thread-1");
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread-2 trying to acquired the lock...");
            try {
                if (locker.tryLock(2, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("Thread-2 acquired the lock...");
                    } finally {
                        locker.unlock();
                    }
                } else {
                    System.out.println("Thread-2 could not acquired the lock.");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread-2");
        thread1.start();
        Thread.sleep(100);
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
