package org.example;

import org.example.multithreading.ExtendThread;
import org.example.multithreading.ImplementRunnable;

public class Main {
    static void main() {

        IO.println("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            IO.println("i = " + i);
        }

        ExtendThread t1 = new ExtendThread();
        ExtendThread t2 = new ExtendThread();
        t1.start();
        t2.start();

        Runnable runnable = new ImplementRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}
