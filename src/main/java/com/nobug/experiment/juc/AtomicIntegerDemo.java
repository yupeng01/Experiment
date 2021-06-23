package com.nobug.experiment.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 多线程对Integer和AtomicInteger共享变量自增结果
 * @createTime 2021年 04月 17:25:00
 */
public class  AtomicIntegerDemo {
    static Integer integerVal = 0;
    static AtomicInteger atomicIntegerVal = new AtomicInteger();

    public static void atomicTest (){
        List<FutureTask<Integer>> ftList = new ArrayList<>();
        for (int i = 0;i < 1000;i++) {
            FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    integerVal += 1;
                    return atomicIntegerVal.incrementAndGet();
                }
            });
            new Thread(futureTask).start();
            ftList.add(futureTask);
        }
        try {
            for (FutureTask<Integer> futureTask : ftList) {
                futureTask.get( );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("integerVal:" + integerVal);
        System.out.println("atomicIntegerVal:" + atomicIntegerVal);
    }

    public static void main(String[] args) {
        atomicTest();
    }
}
