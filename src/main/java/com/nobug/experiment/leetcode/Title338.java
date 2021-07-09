package com.nobug.experiment.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 比特位计数
 * @createTime 2021年 07月 09日 11:28:00
 */
public class Title338 {
    public static int[] countBits(int n) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i <= n; i++) {
            String s = Integer.toBinaryString(i);
            System.out.println(s);
            int count = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
            list.add(count);
        }
        return list.stream().mapToInt(Integer :: intValue).toArray();
    }

    public static void main(String[] args) {
        countBits(2);
    }
}
