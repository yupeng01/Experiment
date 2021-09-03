package com.nobug.experiment.test;

import org.springframework.stereotype.Component;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 实验assert抛出error 是否中断当前进程
 * @createTime 2021年 07月 16日 16:44:00
 */
@Component
public class AssertTest {
    public void testAssert (String s) {
        assert false;
    }

    public static void main(String[] args) {
        int i = 1;
        assert false : "i should not be 1";
        System.out.println("success");
    }
}
