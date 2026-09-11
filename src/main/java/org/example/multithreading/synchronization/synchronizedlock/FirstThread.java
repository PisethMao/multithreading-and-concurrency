package org.example.multithreading.synchronization.synchronizedlock;

public class FirstThread extends Thread {
    MathUtils mathUtils;
    public FirstThread(MathUtils mathUtils) {
        this.mathUtils = mathUtils;
    }

    @Override
    public void run() {
        try {
            mathUtils.getMultiples(2);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
