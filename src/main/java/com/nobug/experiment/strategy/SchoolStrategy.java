package com.nobug.experiment.strategy;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 06月 21日 10:54:00
 */
public abstract class SchoolStrategy<T> {
    void enterClassRoom () {

    }
    //根据不同策略获取不同数据
    abstract T prepare();
    //是否执行该策略
    abstract boolean isRun (T t);
}
