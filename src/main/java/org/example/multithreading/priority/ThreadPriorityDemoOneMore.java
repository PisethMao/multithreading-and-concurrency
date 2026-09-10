package org.example.multithreading.priority;

public class ThreadPriorityDemoOneMore {
    static void main() {
        Thread lowPriority = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " | Priority = " + Thread.currentThread().getPriority() + " | Count = " + i);
            }
        }, "Low-Priority-Thread");
        Thread normalPriority = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " | Priority = " + Thread.currentThread().getPriority() + " | Count = " + i);
            }
        }, "Normal-Priority-Thread");
        Thread highPriority = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " | Priority = " + Thread.currentThread().getPriority() + " | Count = " + i);
            }
        }, "High-Priority-Thread");
        lowPriority.setPriority(Thread.MIN_PRIORITY);
        normalPriority.setPriority(Thread.NORM_PRIORITY);
        highPriority.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Low-Priority-Thread: " + lowPriority.getPriority());
        System.out.println("Normal-Priority-Thread: " + normalPriority.getPriority());
        System.out.println("High-Priority-Thread: " + highPriority.getPriority());
        lowPriority.start();
        normalPriority.start();
        highPriority.start();
    }
}
