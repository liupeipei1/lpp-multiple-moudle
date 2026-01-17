package com.example.common.基础.leetcode.动态规划;

/*
 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
你可以认为每种硬币的数量是无限的。
输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1
输入：coins = [2], amount = 3
输出：-1
 */
public class 零钱兑换 {

    public static void main(String[] args) {
        零钱兑换 solution = new 零钱兑换();
        System.out.printf("\n" + solution.coinChange(new int[]{2}, 3));//2
        System.out.printf("\n" + solution.coinChange(new int[]{1, 2, 5}, 11));//3
        System.out.printf("\n" + solution.coinChange(new int[]{2}, 3));//-1
        System.out.printf("\n" + solution.coinChange(new int[]{1}, 0));//0
        System.out.printf("\n" + solution.coinChange(new int[]{1}, 1));//1
        System.out.printf("\n" + solution.coinChange(new int[]{1}, 2));//2
    }

    /*
    得到最少的硬币数量
    动态规划  f(x) = min(f(x-coin)) +coin 其中 coin 属于 coins 且 coin <=x
     1.状态数组：定义一个一维数组 f，其中 f[i] 表示金额 i 所需的最少硬币数量。
     2.状态转移方程：
        f(i) = min(f(i - coin)) + 1，其中 coin 属于 coins 且 coin <= i。
     3.初始条件：f(0) = 0，因为金额为 0 时不需要任何硬币。
     4.计算顺序：从 1 到 amount 依次计算 f 数组的值。
    解释：
    对于每个金额 i，遍历所有硬币面额 coin。如果 coin 小于等于 i，则可以使用该硬币来组成金额 i。此时，所需的最少硬币数量为 f(i - coin) 加上 1（表示使用了一个面额为 coin 的硬币）。通过遍历所有硬币面额，找到使用最少硬币数量的组合，最终得到 f(amount) 的值。
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount <= 0) return -1;
        int[] f = new int[amount + 1]; //保存每一个金额对应的最少硬币数量
        for (int i = 1; i <= amount; i++) {
            int minCount = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i) {
                    minCount = Math.min(minCount, f[i - coin]);
                }
            }
            if (minCount != Integer.MAX_VALUE && minCount != -1) {
                minCount = minCount + 1;
            }
            f[i] = minCount;
        }
        return f[amount] == Integer.MAX_VALUE || f[amount]==0 ? -1 : f[amount];
    }
}
