package com.example.common.基础.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

/*
给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 */
public class 分割回文数 {
    public static void main(String[] args) {
        var a = partition("aab");
        for (List<String> strings : a) {
            System.out.printf("" + strings);
        }
    }

    /*
     dfs + 回溯 判断是否是回文数
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.isBlank()) return result;
        List<String> path = new ArrayList<>();
        int len = s.length();
        dfs(0, s, len, path, result);
        return result;
    }

    /**
     * 从字符串起始位置开始，遍历所有可能的分割点→校验子串是否为回文→合法则加入路径并递归处理剩余部分→递归返回后回退路径→直到遍历完所有分割点；
     * 当路径覆盖整个字符串时，记录该合法分割结果。
     * 这也是所有「分割类回溯问题」的通用规则：递归的下一轮起点 = 本轮分割的终点 + 1
     * （比如分割 IP 地址、分割回文串、分割字符串为字典单词等，均遵循此逻辑）。
     * DFS + 回溯生成所有回文分割
     * @param index  当前开始处理的字符索引
     * @param s      原始字符串
     * @param len    原始字符串长度（避免重复计算）
     * @param path   当前路径（已选的回文子串）
     * @param result 最终结果集
     */
    public static void dfs(int index, String s, int len, List<String> path, List<List<String>> result) {
        if (index == len) { //终止条件
            result.add(new ArrayList<>(path));
            return;
        }
        // 遍历所有可能的结束位置（从index到len-1），尝试分割出回文子串
        for (int end = index; end < len; end++) {
            // 截取 s[index...end] 作为候选子串
            String current = s.substring(index, end + 1); //是 Java 截取「左闭右开」区间的正确写法
            if (isPalindrome(current)) {
                path.add(current); // 选择：加入当前回文子串
                //end+1 是为了精准跳过「已处理的子串区间」，确保递归处理「未分割的剩余字符串」，而 index+1 只会机械地单字符步进，完全无法适配「多字符回文子串」的分割场景
                dfs(end + 1, s, len, path, result);// 递归处理下一个字符（end+1）
                path.remove(path.size() - 1);// 回溯：移除最后加入的子串，尝试其他分割
            }
        }
    }

    //判断是回文字符串
    public static boolean isPalindrome(String str) {
        int len = str.length();
        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
