package com.nobug.experiment.spring.demo;

import com.nobug.experiment.spring.ioc.AutowiredDemo;
import com.nobug.experiment.spring.ioc.ResourceDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description Demo
 * @createTime 2021年 05月 17:21:00
 */
@Component
public class DemoService {
    public void helloWorld () {
        System.out.println("Hello World");
    }
    public DemoService () {
        System.out.println("DemoService no args constructor");
    }

    @Autowired(required = false)
    public DemoService (AutowiredDemo autowiredDemo) {
        System.out.println("DemoService one args constructor, constructor name is autowiredDemo");
    }

    @Autowired(required = false)
    public DemoService (AutowiredDemo autowiredDemo, ResourceDemo resourceDemo) {
        //System.out.println("DemoService one args constructor, constructor name is autowiredDemo and resourceDemo");
    }
}
