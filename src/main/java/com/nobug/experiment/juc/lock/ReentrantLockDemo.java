package com.nobug.experiment.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock公平锁非公平锁Demo
 */
public class ReentrantLockDemo {
    private static final ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(ReentrantLockDemo::printThreadName,"thread-"+ i).start();
        }
    }

    public static void printThreadName () {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }
}
