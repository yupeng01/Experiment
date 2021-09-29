package com.nobug.experiment.designmodel.producerconsumermodel;

import java.util.Deque;
import java.util.LinkedList;

public class MessageQueue {

    private volatile Deque<String> queue = new LinkedList<>();

    private static volatile MessageQueue messageQueue = null;

    private final static Object sync = new Object();

    private final int MAX_LENGTH = 20;

    private MessageQueue () {

    }

    public void sendMessage (String msg) {
        synchronized (sync) {
            if (!queueIsFull()) {
                queue.offer(msg);
                System.out.println("producer send msg: " + msg);
            }
        }
    }

    public String receiveMessage () {
        while (!hasMessage()) {

        }
        String message = queue.remove();
        System.out.println("consumer receive msg: " + message);
        return message;
    }

    public boolean queueIsFull () {
        return queue.size() >= MAX_LENGTH;
    }

    public boolean hasMessage () {
        return !queue.isEmpty();
    }

    public int printQueueSize() {
        while (true) {
            sleep(2000L);
            System.out.println("queue size: " + queue.size());
        }
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static MessageQueue getInstance () {
        if (messageQueue == null) {
            synchronized (sync) {
                if (messageQueue == null) {
                    messageQueue = new MessageQueue();
                }
            }
        }
        return messageQueue;
    }
}
