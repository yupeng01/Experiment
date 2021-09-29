package com.nobug.experiment.leetcode;

public class Title91 {
    public static int numDecoding(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && dp[i - 1] != '0' && dp[i - 1] * 10 +
                    (int)s.charAt(i - 1) - 48 <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        System.out.println(numDecoding("12"));
    }
}
