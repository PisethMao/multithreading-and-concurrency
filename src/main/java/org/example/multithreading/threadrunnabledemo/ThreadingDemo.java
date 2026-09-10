package org.example.multithreading.threadrunnabledemo;

public class ThreadingDemo {
    static void main() {
        int n = 10;
        for (int i = 0; i < n; i++) {
            ThreadOne threadOne = new ThreadOne();
            threadOne.start();
            ThreadTwo threadTwo = new ThreadTwo();
            Thread threadThree = new Thread(threadTwo);
            threadThree.start();
        }
    }
}
