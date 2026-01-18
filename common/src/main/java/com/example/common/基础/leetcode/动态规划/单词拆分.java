package com.example.common.基础.leetcode.动态规划;

import com.sun.tools.javac.Main;

import java.util.List;

/*
给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
示例 1：
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
示例 2：
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     注意，你可以重复使用字典中的单词。
 */
public class 单词拆分 {

    public static void main(String[] args) {
        单词拆分 solution = new 单词拆分();
        System.out.printf("\n" + solution.wordBreak("leetcode", List.of("leet", "code")));//true
        System.out.printf("\n" + solution.wordBreak("applepenapple", List.of("apple", "pen")));//true
        System.out.printf("\n" + solution.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));//false
    }

    /*
     可以将字符串 s 拆分成若干个子串，使得每个子串都在字典 wordDict 中出现过。
     动态规划  f(x) = f(x - word) 其中 word 属于 wordDict 且 word 是 s 的后缀
      1.状态数组：定义一个一维数组 dp，其中 dp[i] 表示字符串 s 的前 i 个字符是否可以被拆分成字典中的单词。
      2.状态转移方程：
         dp(i) = true，如果存在一个 j (0 <= j < i)，使得 dp(j) 为 true 且 s[j:i] 在 wordDict 中。
      3.初始条件：dp(0) = true，因为空字符串可以被视为已拆分。
      4.计算顺序：从 1 到 s.length() 依次计算 dp 数组的值。
     5.最终结果：dp[s.length()] 即为所求结果，表示整个字符串 s 是否可以被拆分成字典中的单词。
     解释：
     对于每个位置 i，遍历所有可能的拆分点 j。如果存在一个拆分点 j，使得前 j 个字符可以被拆分（即 dp(j) 为 true），且从 j 到 i 的子串 s[j:i] 在字典中出现过，那么前 i 个字符也可以被拆分，设置 dp(i) 为 true。通过遍历所有位置，最终得到 dp[s.length()] 的值，即可判断整个字符串是否可以被拆分成字典中的单词。
      dp[i]=dp[j] && check(s[j..i−1])
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1]; //保存每一个位置是否可以被拆分
        dp[0] = true; //空字符串可以被视为已拆分
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                String subStr = s.substring(j, i); //获取子串  左闭右开
                if (dp[j] && wordDict.contains(subStr)) {
                    dp[i] = true;
                    break; //找到一个即可跳出
                }
            }
        }
        return dp[n];
    }
}
