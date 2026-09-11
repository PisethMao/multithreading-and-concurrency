package org.example.multithreading.deadlock;

@SuppressWarnings("unused")
public class ClassOne {
    private int number = 10;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
