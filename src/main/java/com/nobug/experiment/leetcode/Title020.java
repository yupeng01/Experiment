package com.nobug.experiment.leetcode;

import java.util.*;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 06月 04日 14:43:00
 */
public class Title020 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && (stack.isEmpty() || !stack.pop().equals('('))){
                return false;
            } else if (c == ']' && (stack.isEmpty() || !stack.pop().equals('['))){
                return false;
            } else if (c == '}' && (stack.isEmpty() || !stack.pop().equals('{'))){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValidV2 (String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidV2("()"));
        System.out.println(isValidV2("()[]{}"));
        System.out.println(isValidV2("(]"));
        System.out.println(isValidV2("([)]"));
        System.out.println(isValidV2("{[]}"));
        System.out.println(isValidV2("{"));
        System.out.println(isValidV2("}"));
    }
}
