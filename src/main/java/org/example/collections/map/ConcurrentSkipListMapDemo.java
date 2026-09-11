package org.example.collections.map;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapDemo {
    static void main() throws InterruptedException {
        ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();
        Thread thread1 = Thread.ofVirtual().start(() -> {
            map.put(30, "Kotlin");
            map.put(100, "Linux");
        });
        Thread thread2 = Thread.ofVirtual().start(() -> {
            map.put(20, "Windows");
            map.put(40, "Go");
        });
        thread1.join();
        thread2.join();
        System.out.println(map);
    }
}
