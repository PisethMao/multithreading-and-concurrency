package org.example.collections.que.blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueDemo {
    static void main() throws InterruptedException {
        LinkedBlockingQueue<String> users = new LinkedBlockingQueue<>(3);
        Thread producer = Thread.ofVirtual().start(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    String task = "User " + i;
                    System.out.println("Producing " + task);
                    users.put(task);
                    System.out.println("Queued " + task);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread consumer = Thread.ofVirtual().start(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    String task = users.take();
                    System.out.println("Consuming " + task);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        producer.join();
        consumer.join();
    }
}
