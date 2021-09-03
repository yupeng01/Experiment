package com.nobug.experiment.jdk;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> a - b);
    }
}
