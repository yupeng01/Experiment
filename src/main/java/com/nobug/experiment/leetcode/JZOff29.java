package com.nobug.experiment.leetcode;

import java.util.Arrays;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description 剑指Offer29题
 * @createTime 2021年 05月 27日 15:03:00
 */
public class JZOff29 {
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int[] order = new int[total];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order[i] = matrix[row][column];
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

    public static int[][] initArray () {
        int[] array1 = {1 ,2, 3, 4};
        int[] array2 = {5, 6, 7, 8};
        int[] array3 = {9, 10, 11, 12};
        return new int[][] {array1, array2, array3};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(spiralOrder(initArray())));
    }
}
