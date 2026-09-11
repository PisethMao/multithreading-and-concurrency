package org.example.multithreading.synchronization.synchronizedlock;

public class SecondThread implements Runnable {
    MathUtils mathUtils;

    public SecondThread(MathUtils mathUtils) {
        this.mathUtils = mathUtils;
    }

    @Override
    public void run() {
        try {
            mathUtils.getMultiples(3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
