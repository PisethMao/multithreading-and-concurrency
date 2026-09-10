package org.example.multithreading.synchronization.synchronizedmethod;

public class SynchronizedMethodDemo {
    private int count = 0;
    public synchronized void increment(){
        count++;
    }
    public int getCount(){
        return count;
    }
}
