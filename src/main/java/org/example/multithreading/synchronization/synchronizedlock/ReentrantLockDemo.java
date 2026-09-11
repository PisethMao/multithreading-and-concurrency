package org.example.multithreading.synchronization.synchronizedlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private static final Lock locker = new ReentrantLock();

    private static void printNumbers() {
        locker.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock.");
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
            }
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            locker.unlock();
            System.out.println(Thread.currentThread().getName() + " released the lock.");
        }
    }

    static void main() throws InterruptedException {
        Thread thread1 = new Thread(ReentrantLockDemo::printNumbers, "Thread 1");
        Thread thread2 = new Thread(ReentrantLockDemo::printNumbers, "Thread 2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Main thread finished");
    }
}
