package com.example.common.基础.leetcode.动态规划;

/*
 给你一个字符串 s，找到 s 中最长的 回文 子串。
回文 是正着读和反着读都一样的字符串。

 */
public class 最长回文子串 {
    public static void main(String[] args) {
        最长回文子串 solution = new 最长回文子串();
        String s = "babad";
        String result = solution.longestPalindrome(s);
        System.out.println(result); // 输出: "aba" 或 "bab"
        System.out.println(solution.longestPalindrome("cbbd")); // 输出: bb


    }


    /*中心扩展方法
    将当前的字符作为中心向两边扩展  以当前字符和下一个字符为中心向两边扩展 需要将当前字符串考虑奇偶的情况对称
       // 奇数长度：中心是单个字符（i,i）
        expand(s, i, i);
        // 偶数长度：中心是两个相邻字符（i,i+1）
        expand(s, i, i + 1);
    * */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 分别处理奇数/偶数长度回文，取更长的那个 以当前字符为中心向两边扩展
            String s1 = expandAroundCenter(s, i, i);  // 奇数
            String s2 = expandAroundCenter(s, i, i + 1);  // 偶数
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    //当前坐标向两边扩展
    public String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    /*
       cbbd -> bb
     */
    @Deprecated  //超出时间限制了 暴力枚举
    public String longestPalindrome1(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        String longest = s.substring(0, 1);// 最短的回文字符串 第一个字符
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (checkPalindrome(sub) && sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }
        return longest;
    }

    public boolean checkPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }
        StringBuilder left = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            left.append(s.charAt(i));
        }
        return left.toString().equals(s);
    }

    //判断是回文字符串的优化方法，双指针法
    public boolean checkPalindrome2(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
