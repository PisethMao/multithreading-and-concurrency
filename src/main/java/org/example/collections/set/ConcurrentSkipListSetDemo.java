package org.example.collections.set;

import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListSetDemo {
    static void main() throws InterruptedException {
        ConcurrentSkipListSet<Integer> numbers = new ConcurrentSkipListSet<>();
        Thread thread1 = Thread.ofVirtual().start(() -> {
            numbers.add(10);
            numbers.add(30);
            numbers.add(50);
        });
        Thread thread2 = Thread.ofVirtual().start(() -> {
            numbers.add(10);
            numbers.add(90);
            numbers.add(20);
        });
        thread1.join();
        thread2.join();
        System.out.println(numbers);
    }
}
