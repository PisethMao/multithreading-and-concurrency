package org.example.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class UseCallable {
    static void main() throws ExecutionException, InterruptedException {
        Callable<Integer> callable = () -> 10 + 20;
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        Integer result = futureTask.get();
        System.out.println(result);
    }
}
