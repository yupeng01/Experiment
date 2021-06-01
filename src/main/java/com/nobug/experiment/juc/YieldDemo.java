package com.nobug.experiment.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description Thread类中的yield方法
 * @createTime 2021年 06月 01日 15:14:00
 */
public class YieldDemo implements Callable {

    @Override
    public Integer call() {
        System.out.println(1);
        Thread.yield();
        System.out.println(2);
        return 1;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(99);
        for (int i = 0;i < 99; i++) {
            pool.submit(new YieldDemo());
        }
        pool.shutdown();
    }

}
