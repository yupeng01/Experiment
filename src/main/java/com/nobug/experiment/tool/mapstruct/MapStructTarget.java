package com.nobug.experiment.tool.mapstruct;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 转换目标源
 * @createTime 2021年 05月 13:58:00
 */
@Accessors(chain = true)
@Getter
@Setter
public class MapStructTarget {
    private String name;
    private String birthday;
    private int age;
    private Integer birthYear;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Teacher1 getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher1 teacher) {
        this.teacher = teacher;
    }

    private Teacher1 teacher;
}
