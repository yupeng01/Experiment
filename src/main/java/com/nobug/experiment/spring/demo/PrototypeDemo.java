package com.nobug.experiment.spring.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 原型Bean 的Demo
 * @createTime 2021年 05月 17:30:00
 */
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeDemo {
}
