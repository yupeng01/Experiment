package com.nobug.experiment.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Title15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            int l = i + 1, r = length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    if (nums[l] == nums[l + 1] && nums[r] == nums[r - 1]) {
                        continue;
                    }
                    List<Integer> list = new LinkedList();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                } else if (sum > 0) {
                    r = r - 1;
                } else {
                    l = l + 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(threeSum(new int[]{-1, 0, 1, 2, -1, -4})));
    }
}
