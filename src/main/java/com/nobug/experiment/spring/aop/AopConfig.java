package com.nobug.experiment.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description AOP切面处理
 * @createTime 2021年 05月 14:08:00
 */
@Aspect
@Component
public class AopConfig {
    @Around("execution(* com.nobug.experiment.spring.aop.*.*(..))")
    public void pointCut (ProceedingJoinPoint joinPoint) {
        System.out.println("前置");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("后置");
    }
}
