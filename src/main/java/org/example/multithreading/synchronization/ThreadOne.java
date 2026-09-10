package org.example.multithreading.synchronization;

public class ThreadOne extends Thread {
    MathUtils mathUtils;
    public ThreadOne(MathUtils mathUtils) {
        this.mathUtils = mathUtils;
    }

    @Override
    public void run() {
        try {
            mathUtils.getMultipleUtils(2);
        }catch (Exception e){
            System.out.println("Exception Raised: " + e.getMessage());
        }
    }
}
