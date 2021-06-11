package com.nobug.experiment.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 06月 01日 14:10:00
 */
@RequestMapping("ioc_test")
@RestController()
public class IocTestController {
    private AutowiredDemo autowiredDemo;
    @Resource
    private ResourceDemo resourceDemo;

    private NotBeanDemo notBeanDemo;

    public IocTestController (@Autowired(required = false) NotBeanDemo notBeanDemo) {
        this.notBeanDemo = notBeanDemo;
    }
    @GetMapping("demo01")
    public void demo01 () {
        resourceDemo.helloWorld();
    }
    @Autowired
    public IocTestController (AutowiredDemo autowiredDemo) {
        this.autowiredDemo = autowiredDemo;
        //System.out.println("Nothing to do");
    }
}
