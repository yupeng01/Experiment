package com.nobug.experiment.juc.cas;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 06月 30日 11:50:00
 */
public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(atomicReference.compareAndSet(100, 127));
            System.out.println(atomicReference.get());
            System.out.println(atomicReference.compareAndSet(127, 100));
            System.out.println(atomicReference.get());
        }, "thread-1").start();

        new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2019));
            System.out.println(atomicReference.get());
        }, "thread-2").start();
        try {
            Thread.sleep(510);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----resolve 'ABA' question----");
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " result: " +
                    atomicStampedReference.compareAndSet(100, 110,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1) +
                    " stamp : " + atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName() + " result: " +
                    atomicStampedReference.compareAndSet(110, 100,
                            atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1) +
                    " stamp : " + atomicStampedReference.getStamp());
        }, "thread-3").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " result: " +
                    atomicStampedReference.compareAndSet(100, 2019,
                            stamp, stamp + 1) +
                    " stamp : " + stamp);
        }, "thread-4").start();

        try {
            Thread.sleep(1700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicStampedReference.getReference());
        for (int i = 1; i <= atomicStampedReference.getStamp(); i++) {
            System.out.println("i: " + i + "value: "+ atomicStampedReference.get(new int[]{i}));
        }
    }
}
