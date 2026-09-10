package org.example.multithreading.daemon;

public class DaemonThreadDemo {
    static void main() {
        Thread daemon = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Daemon Thread is running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }, "Background Daemon Thread");
        daemon.setDaemon(true);
        daemon.start();
        System.out.println("Main Thread is finished!!!");
    }
}
