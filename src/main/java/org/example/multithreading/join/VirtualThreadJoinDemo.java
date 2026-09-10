package org.example.multithreading.join;

public class VirtualThreadJoinDemo {
    static void main() throws InterruptedException {
        Thread worker = Thread.startVirtualThread(() -> {
            System.out.println("Virtual Thread Started!" + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted" + Thread.currentThread().isInterrupted());
            }
            System.out.println("Thread is ended!");
        });
        worker.join();
        System.out.println("Main Thread is continues!");
    }
}
