package org.example.multithreading;

public class Lambda {
    static void main() {
        Thread thread1 = new Thread(() -> System.out.println("ImplementRunnable.main(): " + Thread.currentThread().getName()));
        Thread thread2 = new Thread(() -> System.out.println("ImplementRunnable.main(): " + Thread.currentThread().getName()));
        thread1.start();
        thread2.start();
    }
}
