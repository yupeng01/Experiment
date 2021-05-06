package com.nobug.experiment.spring;

import com.nobug.experiment.spring.demo.DemoService;
import org.springframework.stereotype.Component;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description Spring初始化Bean的一些问题
 * @createTime 2021年 05月 17:20:00
 */
@Component
public class InitBeanTest {

    public InitBeanTest (DemoService demoService) {
        demoService.helloWorld();
    }

    public void sayHello () {
        System.out.println("Hello");
    }
}
