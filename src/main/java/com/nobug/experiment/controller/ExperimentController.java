package com.nobug.experiment.controller;

import com.nobug.experiment.statemachine.StateMachineTest;
import org.springframework.beans.factory.annotation.Autowired;
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
    public StateMachineTest stateMachineTest;
    @RequestMapping("hello_world")
    public String getHelloWorld () {
        return "Hello World";
    }
    @RequestMapping("spring_state_machine")
    public void springStateMachine () {
        stateMachineTest.test();
    }
}
