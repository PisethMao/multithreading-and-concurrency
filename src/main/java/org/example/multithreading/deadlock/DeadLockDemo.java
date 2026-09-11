package org.example.multithreading.deadlock;

public class DeadLockDemo {
    static void main() {
        final ClassOne classOne = new ClassOne();
        final ClassTwo classTwo = new ClassTwo();
        Thread t1 = new Thread(new ThreadOne(classOne, classTwo));
        Thread t2 = new Thread(new ThreadTwo(classOne, classTwo));
        t1.start();
        t2.start();
    }
}
