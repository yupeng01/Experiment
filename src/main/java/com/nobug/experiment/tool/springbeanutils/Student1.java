package com.nobug.experiment.tool.springbeanutils;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description BeanUtils的测试实体
 * @createTime 2021年 04月 16:23:00
 */
public class Student1 {
    private String name;
    private Integer age;
    private BigDecimal height;
    private List<String> identityList;
    private Teacher teacher;

    public String getName() {
        return name;
    }

    public Student1 setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Student1 setAge(Integer age) {
        this.age = age;
        return this;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public Student1 setHeight(BigDecimal height) {
        this.height = height;
        return this;
    }

    public List<String> getIdentityList() {
        return identityList;
    }

    public Student1 setIdentityList(List<String> identityList) {
        this.identityList = identityList;
        return this;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Student1 setTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }
}
