package org.example.multithreading.synchronization.synchronizedlock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
    private static final StampedLock stampedLock = new StampedLock();
    private static int value = 100;

    static void writeValue(int newValue) {
        long stamp = stampedLock.writeLock();
        try {
            value = newValue;
            System.out.println("Write StampedLock value: " + value);
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    static int readValue() {
        long stamp = stampedLock.readLock();
        try {
            return value;
        } finally {
            stampedLock.unlockRead(stamp);
        }
    }

    static void main() {
        writeValue(200);
        System.out.println("Read StampedLock value: " + readValue());
        writeValue(300);
        System.out.println("Read StampedLock value: " + readValue());
    }
}
