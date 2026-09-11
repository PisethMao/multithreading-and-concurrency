package org.example.collections.que.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    static void main() throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        Thread producer = Thread.ofVirtual().start(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    String order = "Order #" + i;
                    System.out.println("Processing " + order);
                    queue.put(order);
                    System.out.println("Queue: " + queue);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread consumer = Thread.ofVirtual().start(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    Thread.sleep(1000);
                    String order = queue.take();
                    System.out.println("Consuming " + order);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        producer.join();
        consumer.join();
    }
}
