package org.example.multithreading.deadlock;

@SuppressWarnings("unused")
public class ClassTwo {
    private int number = 20;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
