package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int count = tasks.size();
        for (int i = task.getPriority() - 1; i < tasks.size() ; i++) {
            if (task.getPriority() < tasks.get(i).getPriority()) {
                count = i;
                break;
            }
        }
        this.tasks.add(count, task);
    }

    public Task take() {
        return tasks.poll();
    }
}
