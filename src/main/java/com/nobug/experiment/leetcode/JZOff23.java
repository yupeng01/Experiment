package com.nobug.experiment.leetcode;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 05月 27日 17:47:00
 */
public class JZOff23 {
    public static int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int middleNum = (i + j) / 2;
            if (nums[middleNum] == middleNum) i = middleNum + 1;
                else j = middleNum - 1;
        }
        return i;
    }

    public static int[] initArray () {
        return new int[] {0, 1, 2, 3, 5};
    }
    public static void main(String[] args) {
        System.out.println(missingNumber(initArray()));
    }
}
