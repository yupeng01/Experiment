package com.nobug.experiment.designmodel.producerconsumermodel;

public class Test {
    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        new Thread(producer::produceMessage).start();

        new Thread(consumer::consumeMessage).start();

        MessageQueue messageQueue = MessageQueue.getInstance();
        new Thread(messageQueue::printQueueSize).start();
    }

}
