package com.nobug.experiment.leetcode;

public class Title008 {
    public static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        long result = 0L;
        char[] charArr = s.toCharArray();
        String strSum = "";
        for (char c : charArr) {
            if (c == '-' || (c >= 48 && c <=57)) {
                strSum = strSum + c;
                continue;
            }
            if (strSum.length() > 0) {
                break;
            }
        }
        result = Long.parseLong(strSum);
        if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        myAtoi("words and 987");
    }
}
