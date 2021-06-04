package com.nobug.experiment.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 06月 04日 13:59:00
 */
public class Title001 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i]) && hashMap.get(target - nums[i]) != i) {
                return new int[] {hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
    }
}
