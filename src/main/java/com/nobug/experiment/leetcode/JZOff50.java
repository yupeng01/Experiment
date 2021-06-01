package com.nobug.experiment.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年 05月 27日 19:18:00
 */
public class JZOff50 {
    public static char firstUniqChar (String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static char firstUniqCharV2 (String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? -1 : i);
        }
        int first = n;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int index = entry.getValue();
            if (index != -1 && index < first) {
                first = index;
            }
        }
        return first == n ? ' ' : s.charAt(first);
    }
    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff"));
    }
}
