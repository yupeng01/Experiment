package com.nobug.experiment.jdk;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        Arrays.sort(nums);
        System.out.println(JSON.toJSONString(nums));
    }

    private static void containsList() {
        List<Integer> subList1 = new ArrayList<>();
        subList1.add(1);
        subList1.add(2);
        subList1.add(1);
        List<Integer> subList2 = new ArrayList<>();
        subList2.add(1);
        subList2.add(1);
        subList2.add(2);
        List<List<Integer>> list = new ArrayList<>();
        list.add(subList1);
        list.add(subList2);

        List<Integer> targetList = new ArrayList<>();
        targetList.add(1);
        targetList.add(1);
        targetList.add(2);
        System.out.println(list.contains(targetList));
    }

    private static void copyArrays() {
        int[] arr = new int[]{1, 2, 3, 4, 6};
        int[] resultArr = Arrays.copyOf(arr, 4);
        System.out.println(JSON.toJSONString(resultArr));
    }

}
