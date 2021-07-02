package com.nobug.experiment.juc.sync;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 07月 02日 15:07:00
 */
public class SyncStringDemo {
    String name = "abc";
    String name1 = "abc";

    public void demo1 () {
        new Thread(() -> {
            synchronized (this.name) {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "thread-1").start();

        new Thread(() -> {
           synchronized (this.name1) {
               while (true) {
                   System.out.println(Thread.currentThread().getName());
                   try {
                       Thread.sleep(1000);
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }
           }
        }, "thread-2").start();
    }
    public static void main(String[] args) {
        SyncStringDemo syncStringDemo = new SyncStringDemo();
        syncStringDemo.demo1();
    }
}
