package com.nobug.experiment.juc.volatiledemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description volatile的demo
 * @createTime 2021年 05月 26日 10:30:00
 */
public class VolatileDemo {
    public static final Object sync = new Object();
    public static void main(String[] args) throws InterruptedException {
        checkVolatileVisibility();
    }

    //验证了volatile的可见性
    private static void checkVolatileVisibility() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " come in");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //将volatile修饰的Integer类型的值由默认的0增加至200
            myData.volatileNumberAddTo200();
            //将没有volatile修饰的Integer类型的值由0增加至100
            myData.numberAddTo100();
            System.out.println(Thread.currentThread().getName() + " update Number, volatileNumber: "
                    + myData.volatileNumber +" number: " + myData.number);
        }, "AAA").start();
        System.out.println(Thread.currentThread().getName() + " come in");
        //如果开启这个for循环，下面的while就阻塞不住了
//        while(myData.volatileNumber == 0) {
//
//        }
        //TimeUnit.SECONDS.sleep(4);
        System.out.println(Thread.currentThread().getName() + " volatileNumber :" + myData.volatileNumber);
        while(myData.number == 0) {

        }
        System.out.println(Thread.currentThread().getName() + " number :" + myData.number);
    }

    //验证volatile不保证原子性
    private static void checkVolatileAtomicity() throws InterruptedException {
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.volatileNumberIncr();
                    myData.syncNumberIncr();
                    myData.atomicInteger.incrementAndGet();
                }
            },String.valueOf(i)).start();
        }
        //System.out.println(myData.volatileNumber);
        TimeUnit.SECONDS.sleep(5);
        System.out.println(myData.volatileNumber);
        System.out.println(myData.atomicInteger);
        System.out.println(myData.syncNumber);
    }

    private static int a = 0;
    private static int b = 0;

    //验证volatile禁止指令重排序
    private static void checkVolatileNoReorder () {
        new Thread(() -> {
           while (true) {
               set(1, 1);
               get();
           }
        }).start();

        new Thread(() -> {
            while (true) {
                set(0, 0);
                get();
            }
        }).start();
    }

    private static void set (int x, int y) {
        a = x;
        b = y;
    }

    private static void get () {
        if (a == 1 && b == 0) {
            System.out.println("发生了指令重排序");
        }
    }

}

class MyData {
    public Integer number = 0;
    public volatile Integer volatileNumber = 0;
    public volatile Integer syncNumber = 0;
    public AtomicInteger atomicInteger = new AtomicInteger();
    public void numberAddTo100 () {
        number = 100;
    }
    public void volatileNumberAddTo200 () {
        volatileNumber = 200;
    }
    public void numberAdd100 () {
        number += 100;
    }
    public void volatileNumberAdd200 () {
        volatileNumber += 200;
    }

    public void volatileNumberIncr () {
        volatileNumber++;
    }
    public synchronized void syncNumberIncr () {
        syncNumber++;
    }
}

