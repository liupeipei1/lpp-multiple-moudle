package com.example.common.基础.leetcode.动态规划;

/*
 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
你可以对一个单词进行如下三种操作：
插入一个字符
删除一个字符
替换一个字符
输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
 */
public class 编辑距离 {


    public static void main(String[] args) {
        编辑距离 solution = new 编辑距离();
        String word1 = "horse";
        String word2 = "ros";
        int result = solution.minDistance(word1, word2);
        System.out.println(result); // 输出: 3

    }

    /*
    1. 定义状态：dp[i][j] 表示将 word1 的前 i 个字符转换成 word2 的前 j 个字符所需的最少操作数
    2. 状态转移方程：
       - 如果 word1[i-1] == word2[j-1]，则 dp[i][j] = dp[i-1][j-1]（不需要操作）
       - 否则，dp[i][j] = min(
            dp[i-1][j] + 1,    // 删除 word1 的字符
            dp[i][j-1] + 1,   // 插入 word2 的字符
            dp[i-1][j-1] + 1   // 替换字符
         )
    3. 初始化：
       - dp[0][j] = j（将空字符串转换成 word2 的前 j 个字符需要 j 次插入操作）
       - dp[i][0] = i（将 word1 的前 i 个字符转换成空字符串需要 i 次删除操作）
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 初始化第一行和第一列
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i; // 将 word1 的前 i 个字符删除
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i; // 将 word2 的前 i 个字符插入
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) { //这里-1 是因为dp数组的索引是从1开始的，而字符串的索引是从0开始的
                    dp[i][j] = dp[i - 1][j - 1]; // 字符相同，无需操作
                } else {
                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j] + 1,    // 删除 word1 的字符
                                    dp[i][j - 1] + 1),   // 插入 word2 的字符
                            dp[i - 1][j - 1] + 1           // 替换字符
                    );
                }

            }
        }
        return dp[word1.length()][word2.length()];
    }

}
