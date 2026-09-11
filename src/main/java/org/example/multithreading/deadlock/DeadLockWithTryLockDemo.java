package org.example.multithreading.deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockWithTryLockDemo {
    private static final ReentrantLock lockOne = new ReentrantLock();
    private static final ReentrantLock lockTwo = new ReentrantLock();

    private static void doWork(ReentrantLock firstLock, ReentrantLock secondLock) {
        boolean firstAcquired = false;
        boolean secondAcquired = false;
        try {
            firstAcquired = firstLock.tryLock(1, TimeUnit.SECONDS);
            if (!firstAcquired) {
                System.out.println(Thread.currentThread().getName() + ": first try lock failed");
                return;
            }
            System.out.println(Thread.currentThread().getName() + ": first try lock acquired");
            Thread.sleep(500);
            secondAcquired = secondLock.tryLock(1, TimeUnit.SECONDS);
            if (!secondAcquired) {
                System.out.println(Thread.currentThread().getName() + ": second try lock failed");
                return;
            }
            System.out.println(Thread.currentThread().getName() + ": second try lock acquired");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().isInterrupted() + ": interrupted");
        } finally {
            if (secondAcquired) {
                secondLock.unlock();
            }
            if (firstAcquired) {
                firstLock.unlock();
            }
        }
    }

    static void main() {
        Thread.ofPlatform().name("Thread-One").start(() -> doWork(lockOne, lockTwo));
        Thread.ofPlatform().name("Thread-Two").start(() -> doWork(lockTwo, lockOne));
    }
}
