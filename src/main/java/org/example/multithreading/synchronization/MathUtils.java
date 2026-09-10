package org.example.multithreading.synchronization;

public class MathUtils {
    //    synchronized void getMultipleUtils(int n){
//        for (int i = 1; i <= 5; i++) {
//            System.out.println(n * i);
//            try {
//                Thread.sleep(500);
//            }catch (Exception e){
//                System.out.println(e.getMessage());
//            }
//        }
//    }
    void getMultipleUtils(int n) {
        System.out.println("Beginning 1");
        System.out.println("Beginning 2");
        System.out.println("Beginning 3");
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Ending 1");
        System.out.println("Ending 2");
        System.out.println("Ending 3");
    }
}
