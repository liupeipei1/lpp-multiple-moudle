package com.example.common.基础.leetcode.动态规划;

/*
 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号 子串 的长度。
左右括号匹配，即每个左括号都有对应的右括号将其闭合的字符串是格式正确的，比如 "(()())"。
示例 1：
输入：s = "(()"
输出：2
解释：最长有效括号子串是 "()"
示例 2：

输入：s = ")()())"
输出：4
解释：最长有效括号子串是 "()()"
 */
public class 最长有效括号 {

    public static void main(String[] args) {
        最长有效括号 solution = new 最长有效括号();
        /*System.out.println(solution.longestValidParentheses("(()")); // 输出: 2
        System.out.println(solution.longestValidParentheses(")()())")); // 输出: 4*/
        System.out.println(solution.longestValidParentheses("()(())")); // 输出: 6

    }

    /*
     如果 s[i] = '('，则 dp[i] = 0（以左括号结尾不可能是有效括号）；
     只有 s[i] = ')' 时，才需要计算 dp[i]。
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int n = s.length();
        int maxLen = 0;
        int[] dp = new int[n];//定义 dp[i] 表示：以字符串第 i 个字符（下标从 0 开始）结尾的最长有效括号的长度。
        for (int i = 1; i < n; i++) {
            char currChar = s.charAt(i);
            if (currChar == ')') { //当括号是右括号才需要计算
                char prevChar = s.charAt(i - 1);
                if (prevChar == '(') { //情况1：上一个是(，...() 形式，那么公式就是dp[i] =dp[i-2]+2
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;  //本身i和i-1组成一对括号，再加上i-2位置的最长有效括号长度
                } else if (prevChar == ')') {   // 情况2：上一个是')'，比如 "(())", "()(())"
                    int matchIndex = i - dp[i - 1] - 1; //找到与当前右括号匹配的左括号的位置  所以这里maxIndex也不一定是（
                    if (matchIndex >= 0 && s.charAt(matchIndex) == '(') {
                        dp[i] = dp[i - 1] + 2; //加上当前匹配的这一对括号
                        // 计算当前有效长度：前一段有效长度 + 当前匹配的2个 + 匹配位置前的有效长度
                        dp[i] = dp[i - 1] + 2 + (matchIndex >= 1 ? dp[matchIndex - 1] : 0);
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
