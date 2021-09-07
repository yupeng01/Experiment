package com.nobug.experiment.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Title1221 {
    public static int balancedStringSplit(String s) {
        Deque<Character> stack = new LinkedList();
        char[] charArr = s.toCharArray();
        int result = 0;
        for (char c : charArr) {
            if (stack.isEmpty()) {
                result++;
                stack.push(c);
                continue;
            }
            if (stack.peek() == c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        return result;
    }
    public static void main(String[] args) {
        balancedStringSplit("RLRRLLRLRL");
    }
}
