package com.nobug.experiment.leetcode;

import com.alibaba.fastjson.JSON;

public class BinarySearch {
    public static int[] searchRange(int[] nums, int target) {
        int result = -1;
        int leftIdx = 0, rightidx = nums.length - 1;
        while (leftIdx <= rightidx) {
            int mid = (leftIdx + rightidx) / 2;
            if (nums[mid] == target) {
                result = mid;
                break;
            } else if (nums[mid] > target) {
                rightidx = mid - 1;
            } else {
                leftIdx = mid + 1;
            }
        }
        if (result == -1) {
            return new int[]{-1, -1};
        }
        if (result > 0 && nums[result - 1] == target) {
            return new int[]{result - 1, result};
        }
        return new int[]{result, result + 1};
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString
                (searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
