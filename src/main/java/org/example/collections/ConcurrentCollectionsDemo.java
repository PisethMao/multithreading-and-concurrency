package org.example.collections;

import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollectionsDemo {
    static void main() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (Integer i : list) {
            list.add(5);
            System.out.println(i);
        }
        System.out.println("New List: ");
        for (Integer i : list) {
            list.add(5);
            System.out.println(i);
        }
    }
}
