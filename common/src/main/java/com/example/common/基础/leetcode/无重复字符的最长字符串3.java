package com.example.common.基础.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 geiven a string s, find the length of the longest substring without repeating characters.
 找出字符串中不含有重复字符的 最长子串 的长度。
 */
public class 无重复字符的最长字符串3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        String s1 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
        // System.out.println(lengthOfLongestSubstring(s1));

    }

    /*
      best solution  滑动窗口 + 哈希集合
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        java.util.Set<Character> charSet = new java.util.HashSet<>();
        int left = 0; //左指针
        for (int right = 0; right < s.length(); right++) {
            //当前字符
            while (charSet.contains(s.charAt(right))) {//重复字符
                charSet.remove(s.charAt(left)); //移除左指针位置的字符
                left++; //左指针右移
            }
            charSet.add(s.charAt(right)); //添加当前字符
            maxLength = Math.max(maxLength, right - left + 1); //更新最大长度

        }
        return maxLength;

    }

}
