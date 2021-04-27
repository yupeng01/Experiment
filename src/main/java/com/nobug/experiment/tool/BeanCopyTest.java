package com.nobug.experiment.tool;

import com.alibaba.fastjson.JSON;
import com.nobug.experiment.tool.entity.Student1;
import com.nobug.experiment.tool.entity.Student2;
import com.nobug.experiment.tool.entity.Teacher;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO 测试拷贝DTO时,各个工具的性能差异
 * @createTime 2021年 04月 16:12:00
 */
public class BeanCopyTest {
    public static void springBeanUtilsTest () {
        Student1 student1 = new Student1();
        student1.setName("liyupeng01").setAge(23).setHeight(new BigDecimal("191.111"))
                .setIdentityList(Arrays.asList("程序员","干饭王")).setTeacher(new Teacher().setName("muwenbin").setAge(40));
        Student2 student2 = new Student2();
        //Spring的BeanUtils
        BeanUtils.copyProperties(student1, student2);
        System.out.println("student1:" + JSON.toJSONString(student1));
        System.out.println("student2:" + JSON.toJSONString(student2));
        System.out.println(student1.getTeacher() == student2.getTeacher());
        System.out.println(student1.getIdentityList() == student2.getIdentityList());
    }

    public static void main(String[] args) {
        springBeanUtilsTest();
    }
}
