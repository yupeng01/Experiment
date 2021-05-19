package com.nobug.experiment.controller;

import com.alibaba.fastjson.JSON;
import com.nobug.experiment.controller.entity.BigDecimalDemoEntity;
import com.nobug.experiment.spring.aop.AopDemo;
import com.nobug.experiment.spring.initbean.InitBeanDemo;
import com.nobug.experiment.spring.initbean.PrototypeDemo;
import com.nobug.experiment.spring.statemachine.StateMachineDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 发请求做实验
 * @createTime 2021年 04月 15:58:00
 */
@RequestMapping("/experiment")
@RestController
public class ExperimentController {
    @Autowired
    private StateMachineDemo stateMachineDemo;
    @Autowired
    private InitBeanDemo initBeanDemo;
    @Autowired
    private PrototypeDemo prototypeDemo;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private AopDemo aopDemo;
    @RequestMapping({"hello_world", "hello_world1"})
    public String getHelloWorld () {
        return "Hello World";
    }
    @RequestMapping("spring_state_machine")
    public void springStateMachine () {
        stateMachineDemo.test();
    }
    @RequestMapping("init_bean_test")
    public void initBeanTest () {

    }
    @RequestMapping("init_bean_by_name")
    public void initBeanByName (@RequestParam String name) {

    }
    @RequestMapping("proto_type_test01")
    public void protoTypeTest01 () {
        System.out.println(initPrototypeTest());
    }
    @RequestMapping("proto_type_test02")
    public void protoTypeTest02 () {
        System.out.println(applicationContext.getBean(PrototypeDemo.class));
    }
    @Lookup
    public PrototypeDemo initPrototypeTest () {
        return null;
    }

    @RequestMapping("aop_demo")
    public void aopDemo () {
        aopDemo.eat();
    }
    @RequestMapping("aop_demo_by_name")
    public void aopDemoByName (@RequestParam String name) {
        aopDemo.eat(name);
    }

    @GetMapping("/request_param_demo")
    public void requestParamDemo (@RequestParam String id) {
        System.out.println(id);
    }
    @GetMapping("/request_param_demo/{id}")
    public void requestParamDemo2 (@PathVariable String id) {
        System.out.println(id);
    }
    @GetMapping("/request_param_demo/id")
    public void requestParamDemo3 () {
        System.out.println("3");
    }
    @GetMapping("path_variable_demo/{id}")
    public void pathVariableDemo (@PathVariable String id) {
        System.out.println(id);
    }
    @GetMapping("bigdecimal_demo")
    public void bigDecimalDemo (@RequestBody BigDecimalDemoEntity entity) {
        System.out.println(JSON.toJSONString(entity));
    }
}
