package com.nobug.experiment.controller;

import com.nobug.experiment.test.AssertTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 07月 16日 16:45:00
 */
@RequestMapping("/assert")
@RestController
public class AssertTestController {
    @Autowired
    private AssertTest assertTest;
    @GetMapping("test")
    public String test () {
        throw new Error();
    }
}
