package com.nobug.experiment.spring.contextutil;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 05月 30日 09:59:00
 */
@Component
public class SpringContextUtil implements ApplicationContextAware, BeanFactoryPostProcessor {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    public static Object getBean (String beanName) {
        return applicationContext.getBean(beanName);
    }
    public static String[] getAllBeanName (Object object) {
        return applicationContext.getBeanNamesForType(object.getClass());
    }
    public static String getBeanName (Object object) {
        return getAllBeanName(object)[0];
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        GenericBeanDefinition aopDemo =
                (GenericBeanDefinition) beanFactory.getBeanDefinition("aopDemo");
//        aopDemo.setBeanClass(AopConfig.class);
    }
}
