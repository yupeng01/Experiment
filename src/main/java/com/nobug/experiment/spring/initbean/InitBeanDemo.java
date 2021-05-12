package com.nobug.experiment.spring.initbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description Spring初始化Bean的一些问题
 * @createTime 2021年 05月 17:20:00
 */
@Component
public class InitBeanDemo implements InitializingBean , BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " BeanPostProcessor before init");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "BeanPostProcessor after init");
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean init");
    }
}
