package com.nobug.experiment.tool.mapstruct;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO BeanUtils测试实体
 * @createTime 2021年 04月 16:36:00
 */
public class Teacher1 {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public Teacher1 setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Teacher1 setAge(int age) {
        this.age = age;
        return this;
    }
}
