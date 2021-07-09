package com.nobug.experiment.leetcode;

import com.google.gson.Gson;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 07月 07日 19:40:00
 */
public class Title283 {
    public static void moveZeroes(int[] nums) {
        for (int i = nums.length - 1;i > 0; i--) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = 0;j < i; j++) {
                if (nums[j] == 0) {
                    nums[j] = nums[j + 1];
                    nums[j + 1] = 0;
                }
            }
        }
    }

    public static void moveZerosV2 (int[] nums) {
        int p1 = 0,p2 = 0;
        while (p1 < nums.length) {
            if (nums[p1] != 0) {
                nums[p2] = nums[p1];
                p1++;
                p2++;
                continue;
            }
            p1++;
        }
        while (p2 < nums.length) {
            nums[p2] = 0;
            p2++;
        }
    }
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZerosV2(nums);
        Gson gson = new Gson();
        System.out.println(gson.toJson(nums));
    }
}
