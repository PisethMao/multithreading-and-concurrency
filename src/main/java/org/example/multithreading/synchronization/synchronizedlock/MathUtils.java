package org.example.multithreading.synchronization.synchronizedlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MathUtils {
    Lock locker = new ReentrantLock();

    void getMultiples(int n) {
//        synchronized (this) {
        try {
            locker.lock();
            for (int i = 0; i < 5; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } finally {
            locker.unlock();
        }
//        }
    }
}
