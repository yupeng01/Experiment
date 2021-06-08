package com.nobug.experiment.leetcode;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 06月 07日 19:27:00
 */
public class Title053 {
    public static int maxSubArray (int[] nums) {
        int sum = 0, maxValue = nums[0];
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            maxValue = Math.max(maxValue, sum);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
