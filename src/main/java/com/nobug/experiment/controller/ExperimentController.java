package com.nobug.experiment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 04月 15:58:00
 */
@RequestMapping("/experiment")
@RestController
public class ExperimentController {
    @RequestMapping("hello_world")
    public String getHelloWorld () {
        return "Hello World";
    }
}
