package com.nobug.experiment.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 两个栈实现队列
 * @createTime 2021年 07月 15日 17:04:00
 */
public class JZOff09 {
    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(5);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}
class CQueue {
    Queue<Integer> firstQueue = new LinkedList<>();
    Queue<Integer> secondQueue = new LinkedList<>();
    public CQueue() {

    }

    public void appendTail(int value) {
        firstQueue.add(value);
    }

    public int deleteHead() {
        if (secondQueue.isEmpty()) {
            convertQueue();
        }
        if (secondQueue.isEmpty()) {
            return -1;
        }
        return secondQueue.poll();
    }

    public void convertQueue () {
        if (firstQueue.isEmpty()) return;
        while (!firstQueue.isEmpty()) {
            secondQueue.add(firstQueue.poll());
        }
    }
}