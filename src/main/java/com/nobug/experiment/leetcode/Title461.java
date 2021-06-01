package com.nobug.experiment.leetcode;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 05月 27日 14:37:00
 */
public class Title461 {
    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
    public static void main(String[] args) {
        System.out.println(hammingDistance(9, 1));
        System.out.println(hammingDistance(93, 73));
        System.out.println(hammingDistance(1, 2));
    }
}
