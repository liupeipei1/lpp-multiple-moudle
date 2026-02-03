package com.example.common.基础.leetcode.动态规划;

import java.util.Arrays;

/*
 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
测试用例的答案是一个 32-位 整数。
请注意，一个只包含一个元素的数组的乘积是这个元素的值。
输入: nums = [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
输入: nums = [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

 */
public class 乘积最大子数组 {
    public static void main(String[] args) {
        乘积最大子数组 solution = new 乘积最大子数组();
        // System.out.printf("\n" + solution.maxProduct(new int[]{2, 3, -2, 4}));//6
        // System.out.printf("\n" + solution.maxProduct(new int[]{-2, 0, -1}));//0
        // System.out.printf("\n" + solution.maxProduct(new int[]{-2}));//-2
        System.out.printf("\n" + solution.maxProduct(new int[]{2, -5, -2, -4, 3}));//24
    }

    /*
     关键区别：和「最大子数组和」不同，乘积有个特殊特性 ——负数 × 负数 = 正数，这会导致 “当前最小乘积” 可能在下一步变成 “最大乘积”，这是解题的核心难点。
     对于第 i 个元素 nums[i]，以它结尾的连续子数组只有 3 种可能：
    情况 1：只包含自己（子数组长度为 1）→ 乘积是 nums[i]；
    情况 2：和前一个元素的最大乘积结合 → 乘积是 dp_max[i-1] × nums[i]；
    情况 3：和前一个元素的最小乘积结合 → 乘积是 dp_min[i-1] × nums[i]（处理负负得正）。
    因此：
    dp_max[i] = max(情况1, 情况2, 情况3)；
    dp_min[i] = min(情况1, 情况2, 情况3)。
    动态规划 连续 并且每一个位置都要计算最大值和最小值
     1.状态数组：定义两个一维数组 maxF 和 minF，其中 maxF[i] 表示以元素 nums[i] 结尾的子数组的最大乘积，minF[i] 表示以元素 nums[i] 结尾的子数组的最小乘积。
     2.状态转移方程：
     maxF[i] = Math.max(curr,Math.max(maxF[i-1]* curr,minF[i-1]*curr));
     minF[i] =Math.min(curr,Math.min(maxF[i-1]* curr,minF[i-1]*curr));
        {2, 3, -2, 4}
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] maxF = new int[n]; //保存每一个位置对应的最大乘积
        int[] minF = new int[n];//处理负负得正的情况
        maxF[0] = nums[0];
        minF[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            int curr = nums[i];
            // 关键：当前的最大乘积 = max(当前元素本身, 前一个最大*当前元素, 前一个最小*当前元素)
            maxF[i] = Math.max(curr, Math.max(curr * maxF[i - 1], curr * minF[i - 1]));
            // 关键：当前的最小乘积 = min(当前元素本身, 前一个最大*当前元素, 前一个最小*当前元素)
            minF[i] = Math.min(curr, Math.min(curr * maxF[i - 1], curr * minF[i - 1]));
            // 更新全局最大乘积
            result = Math.max(result, maxF[i]);
        }
        return result;

    }
}
