package com.example.common.基础.leetcode.动态规划;

/*
 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 示例 1：

输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
示例 2：

输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集
 */
public class 分割等和子集 {

    public static void main(String[] args) {
        分割等和子集 demo = new 分割等和子集();
        int[] nums = {1, 5, 11, 5};
        boolean result = demo.canPartition(nums);
        System.out.println(result); // 输出: true
    }

    /*
    对比记忆：
        逆序遍历 = 0-1 背包（元素只能用一次）；
        正序遍历 = 完全背包（元素可以重复用）；
   动态规划 用 0-1 背包思路判断数组中是否存在子集和等于 target；
   1.状态数组：定义一个一维布尔数组 dp，其中 dp[j]
    表示是否存在某个子集，其元素和为 j。
    2.状态转移方程：
    对于每个元素 num 和每个可能的和 j（从大到小遍历）：
    如果 j >= num，则更新 dp[j] 为 dp[j] 或 dp[j - num]。
    3.初始化：
    dp[0] = true，因为和为 0 的子集总是存在（空集）。
    4.最终结果：
    返回 dp[target]，其中 target 是总和的一半。
    复杂度分析：
    时间复杂度：O(n * target)，其中 n 是数组的长度，target 是总和的一半。
    空间复杂度：O(target)，用于存储状态数组 dp。
     */
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        // 如果总和是奇数，无法分割成两个相等的子集
        if (totalSum % 2 != 0) {
            return false;
        }
        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // 和为0时，空集总是可行的
        //dp[j] 表示「是否能通过数组中的元素组合出和为 j 的子集」
        for (int num : nums) {
            for (int j = target; j >= num; j--) {  //这里要逆序遍历 j，确保每个 num 只被使用一次
                // 核心逻辑：更新 dp[j] 的状态  dp[j]（等号右边）：不选当前 num 时，原本就已经能组合出和为 j 的子集；
                //dp[j - num]：选当前 num 时，若能组合出和为 j - num 的子集，那么加上 num 就能组合出和为 j 的子集；
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }
}