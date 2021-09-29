package com.nobug.experiment.test;

import org.springframework.util.Assert;

import java.util.Objects;

public class Demo {

    public static int add (int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        Assert.isTrue(Objects.equals(1, add(2, 1)),
                "add方法异常");
    }
}
