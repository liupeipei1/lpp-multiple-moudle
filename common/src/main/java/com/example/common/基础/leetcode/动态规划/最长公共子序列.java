package com.example.common.基础.leetcode.动态规划;

/*
 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
示例 1：
输入：text1 = "abcde", text2 = "ace"
输出：3
解释：最长公共子序列是 "ace" ，它的长度为 3 。
示例 2：
输入：text1 = "abc", text2 = "abc"
输出：3
解释：最长公共子序列是 "abc" ，它的长度为 3 。
 */
public class 最长公共子序列 {
    public static void main(String[] args) {
        最长公共子序列 solution = new 最长公共子序列();
        String text1 = "abcde";
        String text2 = "ace";
        int result = solution.longestCommonSubsequence(text1, text2);
        System.out.println(result); // 输出: 3
    }

    /*  简而言之就是标识第i个字符和第j个字符是否相等 可以直接看纵坐标是text字符坐标  查询字符串是否存在共同的字符即可
    dp[1][1] = 1 说明text1的第一个字符和text2的第一个字符相等 那么最长公共子序列长度就等于去掉这两个字符的最长公共子序列长度加1
    比如dp[3][2]=dp[2][1] + 1 =2 说明text1的第3个字符和text2的第2个字符相等 那么最长公共子序列长度就等于去掉这两个字符的最长公共子序列长度加1
     1. 如果相等 那么最长公共子序列长度就等于去掉这两个字符的最长公共子序列长度加1
     2. 如果不相等 那么最长公共子序列长度就等于去掉其中一个字符的最长公共子序列长度的最大值
     3. 最后返回整个字符串的最长公共子序列长度
     * 1. 定义状态：dp[i][j] 表示 text1[0..i-1] 和 text2[0..j-1] 的最长公共子序列长度
     * 2. 状态转移方程：
     *    - 如果 text1[i-1] == text2[j-1]，则 dp[i][j] = dp[i-1][j-1] + 1
     *   - 否则，dp[i][j] = max(dp[i-1][j], dp[i][j-1])
     * 3. 初始化：dp[0][j] = 0 和 dp[i][0] = 0（当其中一个字符串为空时，最长公共子序列长度为 0）
     * 子序列不要求是连续的 但是必须是保持相对顺序的 例如 text1 = "abcde", text2 = "ace" 他们的最长公共子序列是 "ace" 长度为3
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(); //纵坐标
        int n = text2.length();//横坐标
        // 初始化DP数组，m+1行n+1列，默认值都是0（满足边界条件）
        int[][] dp = new int[m + 1][n + 1];  //dp[j][0] =0  dp[0][i] = 0
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) { //说明当前字符相同 可以将最长公共子序列长度加1
                    dp[i][j] = dp[i - 1][j - 1] + 1;//dp[i][j] 表示 text1 的前 i 个字符（text1[0..i-1]）和 text2 的前 j 个字符（text2[0..j-1]）的最长公共子序列长度。
                } else {
                    //当前字符不相同 dp[i-1][j]（丢 text1 当前字符）和 dp[i][j-1]（丢 text2 当前字符）是仅有的两种可能，取最大值才能保证不遗漏最长子序列；
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];  // dp[m][n]就是两个完整字符串的LCS长度
    }
}
