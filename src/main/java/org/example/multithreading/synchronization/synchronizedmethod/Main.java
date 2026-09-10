package org.example.multithreading.synchronization.synchronizedmethod;

public class Main {
    static void main() throws InterruptedException {
        SynchronizedMethodDemo synchronizedMethodDemo = new SynchronizedMethodDemo();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                synchronizedMethodDemo.increment();
            }
        });
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                synchronizedMethodDemo.increment();
            }
        });
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println("Final Count is: " + synchronizedMethodDemo.getCount());
    }
}
