package com.nobug.experiment.spring;

import com.nobug.experiment.spring.demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 非SpringBean使用Bean时的问题
 * @createTime 2021年 05月 20日 10:40:00
 */
public class NotSpringBeanDemo {

    @Autowired
    private DemoService demoService;
    public void demoServiceTest () {
        demoService.helloWorld();
    }
    public static void main(String[] args) {
        NotSpringBeanDemo notSpringBeanDemo = new NotSpringBeanDemo();
        notSpringBeanDemo.demoServiceTest();
    }
}
