package com.example.common.基础.leetcode;

import java.util.HashMap;

/*
困难
 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 */

public class 最小覆盖字符串 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
        System.out.println(minWindow1(s, t));

    }

    /*
      滑动窗口
     用 need 记录 t 中每个字符及其需要的数量；window 记录当前窗口中每个字符的数量。
    右指针不断向右扩展，更新 window，当某个字符在窗口中的数量刚好达到 need 中的数量时，have 增加。
    当 have == needCount（即窗口已经包含了 t 的所有字符且数量满足）时，
    尝试移动左指针收缩窗口以寻找更短的合法子串，同时更新最短长度与起始位置。
    通过计数而不是仅仅判断存在，正确处理重复字符。
    复杂度：时间 O(n)（n = s.length），空间 O(k)（k = t 的不同字符数）。
         */
    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char tc = t.charAt(i);
            need.put(tc, need.getOrDefault(tc, 0) + 1);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int have = 0;
        int needCount = need.size();
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0; //记录最小覆盖子串的起始位置
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            window.put(rc, window.getOrDefault(rc, 0) + 1);//记录s中每个字符出现的次数
            if (need.containsKey(rc) && window.get(rc).intValue() == need.get(rc).intValue()) {
                have++;
            }

            while (have == needCount) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }
                char lc = s.charAt(left);
                window.put(lc, window.get(lc) - 1);
                //你比较的是减一之后的新计数，所以用严格小于：window.get(lc) < need.get(lc)，表示该字符的数量已经低于需要的数量，必须将 have 减一。
                if (need.containsKey(lc) && window.get(lc).intValue() < need.get(lc).intValue()) {
                    have--;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }

    public static String minWindow1(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> needMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) { //record 目标字符串出现的次数
            char c = t.charAt(i);
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }
        /*
          正式循环
         */
        int left = 0;
        int minLeft = 0;
        int have = 0; //符合目标的字符串的个数
        int minLength = Integer.MAX_VALUE;

        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s.length(); i++) { //窗口的字符出现的次数
            char c = s.charAt(i);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (needMap.containsKey(c) && needMap.get(c).intValue() == window.get(c).intValue()) {
                have++;
            }
            while (have == needMap.size()) {//当符合这个字符串需要记录这个最小的长度
                if (i - left + 1 < minLength) { //当窗口的值小于最小值 需要缩减窗口
                    minLength = i - left + 1;
                    minLeft = left;
                }
                char lc = s.charAt(left);//减去左边的字符量
                //需要减去窗口的已经存在过的字符次数
                window.put(lc, window.get(lc).intValue() - 1);
                if (needMap.containsKey(lc) && window.get(lc).intValue() < needMap.get(lc).intValue()) {
                    have--; //如果存在
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);

    }
}
