package com.nobug.experiment.spring.circlereference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 06月 11日 11:51:00
 */
@Component
public class A {
    @Autowired
    B b;
    public A () {
        System.out.println("init A success");
    }
}
