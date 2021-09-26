package com.nobug.experiment.juc.lock;

public class DeadLock {
    Object a = new Object();
    Object b = new Object();

    public void syncOne() {
        synchronized (a) {
            try {
                System.out.println("ThreadA will sleep");
                Thread.sleep(100L);
                System.out.println("ThreadA is awake");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (b) {
                System.out.println("method syncOne is arrived");
            }
        }
    }

    public void syncTwo() {
        synchronized (b) {
            try {
                System.out.println("ThreadB is sleep");
                Thread.sleep(100L);
                System.out.println("ThreadB is awake");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (a) {
                System.out.println("method syncTwo is arrived");
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread(deadLock::syncOne).start();
        deadLock.syncTwo();
    }
}
