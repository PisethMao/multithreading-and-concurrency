package org.example.multithreading.deadlock;

import java.lang.management.ThreadInfo;
import java.util.concurrent.TimeUnit;

public class ThreadMXBean {
    private static final Object lockOne = new Object();
    private static final Object lockTwo = new Object();

    public static void sleep(long millisecond) {
        try {
            TimeUnit.MILLISECONDS.sleep(millisecond);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static void main() {
        Thread.ofPlatform().name("Thread-One").start(() -> {
            synchronized (lockOne) {
                System.out.println("Thread-One is acquired lock one.");
                sleep(1000);
                synchronized (lockTwo) {
                    System.out.println("Thread-One is acquired lock two.");
                }
            }
        });
        Thread.ofPlatform().name("Thread-Two").start(() -> {
            synchronized (lockTwo) {
                System.out.println("Thread-Two is acquired lock two.");
                sleep(1000);
                synchronized (lockOne) {
                    System.out.println("Thread-Two is acquired lock one.");
                }
            }
        });
        Thread.ofPlatform().name("Deadlock-Monitor").start(() -> {
            java.lang.management.ThreadMXBean threadMXBean = java.lang.management.ManagementFactory.getThreadMXBean();
            while (true) {
                sleep(2000);
                long[] deadlockedThreadIds = threadMXBean.findDeadlockedThreads();
                if (deadlockedThreadIds != null) {
                    System.out.println("\nDEADLOCKED THREADS IS DETECTED!!!");
                    ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(deadlockedThreadIds, true, true);
                    for (ThreadInfo threadInfo : threadInfos) {
                        System.out.println("\nThread " + threadInfo.getThreadName() + ", " + threadInfo.getThreadId());
                        System.out.println("Waiting For: " + threadInfo.getLockName());
                        System.out.println("Owner: " + threadInfo.getLockOwnerName());
                    }
                    break;
                }
            }
        });
    }
}
