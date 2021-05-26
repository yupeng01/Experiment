package com.nobug.experiment.spring.autowire;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 05月 24日 19:00:00
 */
@Component
public class AutoWiredDemo1 implements InitializingBean {
    @Autowired
    private AutowiredDemo2 autowiredDemo2;
    public AutoWiredDemo1 () {

    }
    @PostConstruct
    public void afterProcess () {
        autowiredDemo2.say();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
