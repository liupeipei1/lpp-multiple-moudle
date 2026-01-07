package com.example.common.基础.leetcode.贪心算法;

import java.util.ArrayList;
import java.util.List;

/*
 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，但类似 ["aba", "bcc"]
  或 ["ab", "ab", "cc"] 的划分是非法的。
 */
public class 划分字母区间 {

    public static void main(String[] args) {
        List<Integer> r = partitionLabels("ababcc");
        for (Integer i : r) {
            System.out.printf("" + i);
        }
    }

    public static List<Integer> partitionLabels(String s) {
        int len = s.length();
        int[] last = new int[26]; //将字母按照顺序 将value对应的是 该字母最后出现的下标
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';//a对应的下标是0
            last[index] = i;//值对应的是字符串的下标
        }
        List<Integer> result = new ArrayList<>();
        int end = 0, start = 0;
        for (int i = 0; i < len; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']); //从每一个字母的结束index
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;//第二次的开始位置
            }
        }
        return result;
    }
}
