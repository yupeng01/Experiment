package com.nobug.experiment.designmodel.producerconsumermodel;

public class Consumer {
    public void consumeMessage () {
        MessageQueue messageQueue = MessageQueue.getInstance();
        while (true) {
            sleep(1000L);
            messageQueue.receiveMessage();
        }
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
