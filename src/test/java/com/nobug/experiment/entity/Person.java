package com.nobug.experiment.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Person {
    private String name;

    private Integer age;

    private String phone;

    private Date CreateTime;
}
