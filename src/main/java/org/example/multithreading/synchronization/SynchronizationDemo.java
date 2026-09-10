package org.example.multithreading.synchronization;


public class SynchronizationDemo {
    static void main() {
        MathUtils  mathUtils = new MathUtils();
        ThreadOne threadOne = new ThreadOne(mathUtils);
        ThreadTwo threadTwo = new ThreadTwo(mathUtils);
        Thread threadThree = new Thread(threadTwo);
        threadOne.start();
        threadThree.start();
    }
}
