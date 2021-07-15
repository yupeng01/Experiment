package com.nobug.experiment.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 找到数组中重复的数字
 * @createTime 2021年 07月 15日 11:32:00
 */
public class JZOff03 {
    public static int findRepeatNumber (int[] nums) {
        for (int i = 0;i < nums.length; i++) {
            if (nums[Math.abs(nums[i])] < 0) {
                return Math.abs(nums[i]);
            }
            nums[Math.abs(nums[i])] *= -1;
        }
        return 0;
    }
    public static int findRepeatNumberV2 (int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1, 15};
        System.out.println(findRepeatNumber(nums));
    }
}
