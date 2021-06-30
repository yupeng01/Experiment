package com.nobug.experiment.juc.cas;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description CAS机制顺序打印abc
 * @createTime 2021年 05月 15:11:00
 */
public class CasDemo implements Runnable{
    private static final AtomicInteger currentNum = new AtomicInteger();
    private static String[] charArr = {"a","b","c"};
    private String name;
    public CasDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        //循环60次
        while (currentNum.get() < 60) {
            //打印和数组中元素名称相同的元素
            if (this.name.equals(charArr[currentNum.get() % 3])) {
                System.out.println(name);
                //currentNum自增
                currentNum.getAndIncrement();
            }
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 20, TimeUnit.MINUTES, new LinkedBlockingDeque<>());
        threadPoolExecutor.execute(new CasDemo("a"));
        threadPoolExecutor.execute(new CasDemo("b"));
        threadPoolExecutor.execute(new CasDemo("c"));
        threadPoolExecutor.shutdown();
    }

}
