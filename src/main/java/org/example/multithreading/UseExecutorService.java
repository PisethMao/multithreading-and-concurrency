package org.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UseExecutorService {
    static void main() {
        try (ExecutorService executorService = Executors.newFixedThreadPool(5)) {
            executorService.submit(() -> System.out.println(Thread.currentThread().getName() + " is running!"));
        }
    }
}
