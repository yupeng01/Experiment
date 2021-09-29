package com.nobug.experiment.designmodel.producerconsumermodel;

public class Producer {

    public void produceMessage() {
        MessageQueue messageQueue = MessageQueue.getInstance();
        int i = 0;
        while (true) {
            i++;
            final int j = i;
            new Thread(() -> {
                messageQueue.sendMessage("message:" + j);
            }).start();
            sleep(500L);
        }
    }
    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
