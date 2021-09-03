package com.nobug.experiment.jdk;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 6};
        int[] resultArr = Arrays.copyOf(arr, 4);
        System.out.println(JSON.toJSONString(resultArr));
    }
}
