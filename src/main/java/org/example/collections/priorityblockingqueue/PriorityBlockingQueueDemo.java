package org.example.collections.priorityblockingqueue;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {
    static void main() throws InterruptedException {
        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        Thread thread = Thread.ofVirtual().start(() -> {
            queue.put(new Task("Send Email", 3));
            queue.put(new Task("Process Payment", 1));
            queue.put(new Task("Generate Report", 5));
            queue.put(new Task("Security Alert", 2));
            queue.put(new Task("Clean Up", 10));
        });
        thread.join();
        while (!queue.isEmpty()) {
            Task task = queue.take();
            System.out.printf("Processing %-20s Priority: %d%n", task.name(), task.priority());
        }
    }
}
