package com.example.common.基础.leetcode.动态规划;

import java.util.Arrays;

/*
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
示例 2：

输入：nums = [0,1,0,3,2,3]
输出：4

输入：nums = [7,7,7,7,7,7,7]
输出：1
 */
public class 最长递增子序列 {

    public static void main(String[] args) {
        最长递增子序列 solution = new 最长递增子序列();
        System.out.printf("" + solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));//4
        System.out.printf("\n" + solution.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));//

    }

    /*
    动态规划  f(x) = max(f(x-1), f(x-2) ... f(0)) +1  if nums[x] > nums[i] 其中 i 属于 [0,x-1]
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n]; //保存每一个位置对应的最长递增子序列长度
        dp[0] = 1; //第一个位置最长递增子序列长度为1
        for (int i = 1; i < n; i++) {
            int maxLen = 0;
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    maxLen = Math.max(maxLen, dp[j]);
                }
            }
            maxLen = maxLen + 1;
            dp[i] = maxLen;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
