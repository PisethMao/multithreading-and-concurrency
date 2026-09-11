package org.example.collections.set;

import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo {
    static void main() throws  InterruptedException {
        CopyOnWriteArraySet<String> users = new CopyOnWriteArraySet<>();
        users.add("Piseth");
        users.add("Phaneth");
        users.add("Pisal");
        Thread readers = Thread.ofVirtual().start(() -> {
            for (String user : users) {
                System.out.println("Reading: " + user);
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        });
        Thread writers = Thread.ofVirtual().start(() -> {
            try {
                Thread.sleep(700);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            users.add("Hongleap");
            users.add("Piseth");
            System.out.println("Writer Added Data");
        });
        readers.join();
        writers.join();
        System.out.println("Final Set: " + users);
    }
}
