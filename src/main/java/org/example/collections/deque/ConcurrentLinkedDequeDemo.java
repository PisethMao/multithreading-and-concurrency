package org.example.collections.deque;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequeDemo {
    static void main() throws InterruptedException {
        ConcurrentLinkedDeque<String> users = new ConcurrentLinkedDeque<>();
        Thread thread1 = Thread.ofVirtual().start(() -> {
            users.addFirst("first");
            users.addFirst("second");
            System.out.println("Thread 1 Added Users!!!");
        });
        Thread thread2 = Thread.ofVirtual().start(() -> {
            users.addLast("third");
            users.addLast("fourth");
            System.out.println("Thread 2 Added Users!!!");
        });
        thread1.join();
        thread2.join();
        System.out.println("Deque: " + users);
        System.out.println("First: " + users.peekFirst());
        System.out.println("Last: " + users.peekLast());
        System.out.println("Removed First: " + users.pollFirst());
        System.out.println("Removed Last: " + users.pollLast());
        System.out.println("Remaining Users: " + users);
    }
}
