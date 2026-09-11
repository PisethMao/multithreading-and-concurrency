package org.example.collections.priorityblockingqueue;

public record Task(
        String name,
        int priority
) implements Comparable<Task> {
    @Override
    public int compareTo(Task o) {
        return Integer.compare(this.priority, o.priority);
    }
}
