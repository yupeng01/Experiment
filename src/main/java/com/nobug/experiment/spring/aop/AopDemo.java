package com.nobug.experiment.spring.aop;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description Spring AOP的测试Demo
 * @createTime 2021年 05月 14:06:00
 */
@Service
public class AopDemo {

    public void eat () {
        System.out.println("吃饭");
        AopDemo aopDemo = (AopDemo) AopContext.currentProxy();
        aopDemo.sleep();
    }

    public void sleep () {
        System.out.println("睡觉");
    }
    public void eat (String name) {
        System.out.println(name + "吃饭");
    }

}
