package com.nobug.experiment.spring.initbean;

import com.nobug.experiment.spring.demo.DemoService;
import org.springframework.stereotype.Component;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description Spring初始化Bean的一些问题
 * @createTime 2021年 05月 17:20:00
 */
@Component
public class InitBeanDemo {

    public InitBeanDemo(DemoService demoService) {
        demoService.helloWorld();
    }

    public void sayHello () {
        System.out.println("Hello");
    }

    public void sayHello (String name) {
        System.out.println(name + "Hello");
    }
}
