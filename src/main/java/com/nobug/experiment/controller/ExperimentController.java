package com.nobug.experiment.controller;

import com.nobug.experiment.spring.InitBeanTest;
import com.nobug.experiment.spring.PrototypeTest;
import com.nobug.experiment.statemachine.StateMachineTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 小实验
 * @createTime 2021年 04月 15:58:00
 */
@RequestMapping("/experiment")
@RestController
public class ExperimentController {
    @Autowired
    private StateMachineTest stateMachineTest;
    @Autowired
    private InitBeanTest initBeanTest;
    @Autowired
    private PrototypeTest prototypeTest;
    @Autowired
    private ApplicationContext applicationContext;
    @RequestMapping("hello_world")
    public String getHelloWorld () {
        return "Hello World";
    }
    @RequestMapping("spring_state_machine")
    public void springStateMachine () {
        stateMachineTest.test();
    }
    @RequestMapping("init_bean_test")
    public void initBeanTest () {
        initBeanTest.sayHello();
    }
    @RequestMapping("proto_type_test01")
    public void protoTypeTest01 () {
        System.out.println(initPrototypeTest());
    }
    @RequestMapping("proto_type_test02")
    public void protoTypeTest02 () {
        System.out.println(applicationContext.getBean(PrototypeTest.class));
    }
    @Lookup
    public PrototypeTest initPrototypeTest () {
        return null;
    }
}
