package com.example.common.基础.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找到字符串中间所有的字母异位词 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
        System.out.println(findAnagrams2(s, p));
        System.out.println(findAnagrams2("ddzghjkl", p));

    }

    /*
    解決方法一  滑動窗口 + 字符計數  当前窗口中的字符计数与 p 中的字符计数相同时，说明找到了一个异位词
        给定两个字符串 s 和 p ，找到 s 中所有 p 的 异位词 的起始索引。
        异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
        输入：s = "cbaebabacd", p = "abc"
        输出：[0,6]
        解释：
        起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
        起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。

     */
    public static List<Integer> findAnagrams(String s, String p) {
        // 统计p中每个字符的频率
        if (s.isBlank() || p.isBlank() || s.length() < p.length()) return new ArrayList<>();
        int[] pCount = new int[26];
        //[ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;  // 统计p中每个字符的频率  注意a的ASCII码是97 这里-a是为了从0开始
        }
        List<Integer> result = new ArrayList<>();
        int[] sCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            // 当窗口大小超过p的长度时，移除左侧字符
            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;//将窗口左侧移动
            }
            // 比较两个频率数组是否相等
            if (i >= p.length() - 1 && java.util.Arrays.equals(sCount, pCount)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }

    /*
      滑动窗口 另外一种方式
     */

    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }
        int sLength = s.length(), pLength = p.length();

        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (int i = 0; i < pLength; i++) {  //将p和s的前pLength个字符进行计数
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            result.add(0);
        }
        for (int i = 0; i < sLength - pLength; i++) {
            sCount[s.charAt(i) - 'a']--; //移除左侧字符计数
            sCount[s.charAt(i + pLength) - 'a']++; //添加右侧字符
            if (Arrays.equals(sCount, pCount)) {
                result.add(i + 1);
            }
        }
        return result;
    }


}
