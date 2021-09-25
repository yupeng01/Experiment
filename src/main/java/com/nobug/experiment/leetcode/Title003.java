package com.nobug.experiment.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Title003 {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        char[] charArr = s.toCharArray();
        int maxLength = 0;
        int left = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(charArr[i])) {
                left = map.get(charArr[i]) + 1;
            }
            map.put(charArr[i], i);
            maxLength = Math.max(maxLength, i + 1 - left);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
