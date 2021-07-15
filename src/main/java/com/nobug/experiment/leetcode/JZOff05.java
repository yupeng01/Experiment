package com.nobug.experiment.leetcode;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 07月 15日 11:50:00
 */
public class JZOff05 {
    public static String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (' ' == c) {
                builder.append("%20");
                continue;
            }
            builder.append(c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }
}
