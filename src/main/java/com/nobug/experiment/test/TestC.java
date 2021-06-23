package com.nobug.experiment.test;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 06月 22日 22:41:00
 */
@Data
public class TestC {
    private TestB testB;

    public static void main(String[] args) {
        TestA testA = new TestA();
        TestB testB = new TestB();
        TestC testC = new TestC();
        testA.setTestB(testB);
        testC.setTestB(testB);
        System.out.println(JSON.toJSONString(testA));
        System.out.println(JSON.toJSONString(testC));
        testB = null;
        System.out.println(JSON.toJSONString(testA));
        System.out.println(JSON.toJSONString(testC));
    }
}
