package org.example.multithreading.synchronization.synchronizedlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {
    private static final ReentrantReadWriteLock locker = new ReentrantReadWriteLock();
    public static String data = "Initial Data";

    private static void readData() {
        locker.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is reading: " + data);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            locker.readLock().unlock();
        }
    }

    private static void writeData() {
        locker.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is writing...");
            data = "Write Data";
        } finally {
            locker.writeLock().unlock();
        }
    }

    static void main() throws InterruptedException {
        Thread thread1 = new Thread(ReentrantReadWriteLockDemo::readData, "Reader-1");
        Thread thread2 = new Thread(ReentrantReadWriteLockDemo::readData, "Reader-2");
        Thread thread3 = new Thread(ReentrantReadWriteLockDemo::writeData, "Writer-3");
        thread1.start();
        thread2.start();
        Thread.sleep(100);
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
    }
}
