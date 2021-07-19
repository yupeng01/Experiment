package com.nobug.experiment.leetcode;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 斐波那契数列
 * @createTime 2021年 07月 15日 17:35:00
 */
public class JZOff10_1 {
    public int fibV1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibV1(n - 1) + fibV1(n - 2);
    }

    public int fibV2 (int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        JZOff10_1 jz = new JZOff10_1();
        System.out.println(jz.fibV2(2));
        System.out.println(jz.fibV2(3));
        System.out.println(jz.fibV2(4));
        System.out.println(jz.fibV2(5));
        System.out.println(jz.fibV2(6));
        System.out.println(jz.fibV2(7));
    }
}
