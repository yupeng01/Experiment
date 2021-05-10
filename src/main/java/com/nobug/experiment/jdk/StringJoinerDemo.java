package com.nobug.experiment.jdk;

import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description StringJoiner示例
 * @createTime 2021年 05月 11:13:00
 */
public class StringJoinerDemo {
    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(",");
        IntStream.range(1, 10).forEach(item -> stringJoiner.add(item + ""));
        System.out.println(stringJoiner);
    }
}
