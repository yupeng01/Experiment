package com.nobug.experiment.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 找出数组中数量多的数
 * @createTime 2021年 07月 09日 14:10:00
 */
public class Title169 {
    public static int majorityElement (int[] arr) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int num : arr) {
            if (numCountMap.containsKey(num)) {
                numCountMap.put(num, numCountMap.get(num) + 1);
                continue;
            }
            numCountMap.put(num, 1);
        }
        int maxCount = numCountMap.get(arr[0]);
        int maxValue = arr[0];
        for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxValue = entry.getKey();
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 1, 1, 1, 1, 2, 2}));
    }
}
