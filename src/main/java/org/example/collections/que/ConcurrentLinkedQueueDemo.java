package org.example.collections.que;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueDemo {
    static void main() throws InterruptedException {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        Thread producer = Thread.ofVirtual().start(() -> {
            queue.offer("Java");
            queue.offer("Android");
            queue.offer("Eclipse");
        });
        Thread p1 = Thread.ofVirtual().start(() -> {
            queue.offer("Kotlin");
            queue.offer("Linux");
            queue.offer("Windows");
        });
        producer.join();
        p1.join();
        System.out.println(queue);
        while (!queue.isEmpty()) {
            System.out.println("Processing: " + queue.poll());
        }
    }
}
