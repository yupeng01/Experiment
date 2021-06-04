package com.nobug.experiment.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 06月 03日 19:21:00
 */
public class Title525 {
    /**
     *
     * @param nums
     * @return
     */
    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0}));
    }
}
