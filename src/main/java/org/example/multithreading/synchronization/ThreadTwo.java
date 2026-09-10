package org.example.multithreading.synchronization;

public class ThreadTwo implements Runnable {
    MathUtils math;

    public ThreadTwo(MathUtils math) {
        this.math = math;
    }

    @Override
    public void run() {
        try {
            math.getMultipleUtils(3);
        }catch (Exception e){
            System.out.println("Exception in TreadTwo is caught:  " + e.getMessage());
        }
    }
}
