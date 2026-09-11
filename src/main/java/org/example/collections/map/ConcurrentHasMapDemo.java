package org.example.collections.map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHasMapDemo {
    static void main() throws InterruptedException {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        Thread t = Thread.ofVirtual().start(() -> {
            for (int i = 1; i <= 1000; i++) {
                map.merge("Java", 1, Integer::sum);
            }
        });
        Thread t1 = Thread.ofVirtual().start(() -> {
            for (int i = 1; i <= 1000; i++) {
                map.merge("Java", 1, Integer::sum);
            }
        });
        t.join();
        t1.join();
        System.out.println(map);
    }
}
