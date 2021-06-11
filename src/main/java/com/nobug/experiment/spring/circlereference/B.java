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
public class B {
    @Autowired
    A a;

    public B () {
        System.out.println("init B success");
    }
    public static void main(String[] args) {
        B b = new B();
    }
}
