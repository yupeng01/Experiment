package com.nobug.experiment.leetcode;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * @createTime 2021年 07月 02日 16:29:00
 */
public class Title121 {
    public static void main(String[] args) {
        int[] numArr = {7, 1, 5, 3, 6, 4};
        maxProfit(numArr);
        int[] numArr1 = {7, 6, 4, 3, 1};
        maxProfit(numArr1);
    }

    private static void maxProfit(int[] numArr) {
        int minValue = numArr[0];
        int maxSub = 0;
        for (int i = 1; i < numArr.length; i++) {
            if (numArr[i] < minValue) {
                minValue = numArr[i];
                continue;
            }
            maxSub = Math.max(numArr[i] - minValue, maxSub);
        }
        System.out.println(maxSub);
    }
}
