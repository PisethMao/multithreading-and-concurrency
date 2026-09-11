package org.example.multithreading.synchronization.synchronizedlock;

public class LockDemo {
    static void main() {
        MathUtils mathUtils = new MathUtils();
        FirstThread firstThread = new FirstThread(mathUtils);
        SecondThread secondThread = new SecondThread(mathUtils);
        Thread t1 = new Thread(secondThread);
        firstThread.start();
        t1.start();
    }
}
