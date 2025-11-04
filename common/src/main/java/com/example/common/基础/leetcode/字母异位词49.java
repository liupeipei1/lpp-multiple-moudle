package com.example.common.基础.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 字母异位词49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);

        List<List<String>> result1 = groupAnagrams2(strs);
        System.out.printf("" + result1);

    }

    //将不同顺序的异位字母词归为一类
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new java.util.ArrayList<>();
        }
        java.util.Map<String, java.util.List<String>> groups = new java.util.HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i] == null ? "" : strs[i].toLowerCase();
            char[] ch = s.toCharArray();
            java.util.Arrays.sort(ch);//将字符数组排序
            String key = new String(ch);
            java.util.List<String> list = groups.get(key);
            if (list == null) {
                list = new java.util.ArrayList<>();
                groups.put(key, list);
            }
            list.add(s);
        }
        return new java.util.ArrayList<>(groups.values());
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new java.util.ArrayList<>();
        }
        java.util.Map<String, java.util.List<String>> groups = new java.util.HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            java.util.Arrays.sort(ch);//将字符数组排序
            String key = new String(ch);
            List<String> lists = groups.get(key);
            if (lists == null) {
                lists = new java.util.ArrayList<>();
                groups.put(key, lists);
            }
            lists.add(s);
        }
        return new ArrayList<>(groups.values());
    }
}
