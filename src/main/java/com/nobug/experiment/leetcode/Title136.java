package com.nobug.experiment.leetcode;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 07月 02日 17:30:00
 */
public class Title136 {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        System.out.println(result);
    }
}
