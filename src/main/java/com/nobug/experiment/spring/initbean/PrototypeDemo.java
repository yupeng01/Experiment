package com.nobug.experiment.spring.initbean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 原型Bean测试
 * @createTime 2021年 05月 17:29:00
 */
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeDemo {

}
