package com.nobug.experiment.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description
 * @createTime 2021年 07月 08日 19:26:00
 */
public class Title448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList();
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1;i <= nums.length;i++) {
            if(!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }
    public static List<Integer> findDisappearedNumbersV2 (int[] nums) {
        for (int i = 0;i < nums.length;i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
               nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1] * -1;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbersV2(new int[]{4,3,2,7,8,2,3,1}));
    }
}
