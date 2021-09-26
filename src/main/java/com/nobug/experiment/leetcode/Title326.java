package com.nobug.experiment.leetcode;

public class Title326 {
    public static boolean isPowerOfThree(int n) {
        while (n > 1) {
            n = n / 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(45));
    }
}
