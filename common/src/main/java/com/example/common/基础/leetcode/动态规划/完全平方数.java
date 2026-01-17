package com.example.common.基础.leetcode.动态规划;

/*
给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，
其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
a= b*b+ c*c
12= 4+4+4 =3
13=4+9=2
输入：n = 12
 */
public class 完全平方数 {

    public static void main(String[] args) {
        完全平方数 a = new 完全平方数();
        System.out.printf("" + a.numSquares(12));//3
        System.out.printf("\n" + a.numSquares(13));//2
        System.out.printf("\n" + a.numSquares(4));//1
        System.out.printf("\n" + a.numSquares(6));//3

    }

    /*
    状态数组记录子问题的最优解：
    dp[i]表示数字i的完全平方数的最少数量。
    状态转移方程：
    dp[i] = min(dp[i - j*j]) + 1，其中j*j <= i。
    初始条件：
    dp[0] = 0，因为数字0不需要任何完全平方数。
    计算顺序：
    从1到n依次计算dp数组的值。
    i= j*j + (i-j*j) -> dp[i] = dp[j*j] + dp[i-j*j]  j*j <= i
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // 2.1 初始化当前最小值为“无穷大”，用来找最小的f[i-j²]
        // 2. 遍历1~n，逐个计算f[i]（从最小的数开始算，保证子问题已解决）
        for (int i = 1; i <= n; i++) {
            int minCount = Integer.MAX_VALUE;
            // 2.2 遍历所有可能的平方数j²（j从1开始，j²≤i）
            for (int j = 1; j * j <= i; j++) {
                // 找f[i-j²]的最小值（因为f[i] = f[i-j²] + f[j²]）
                    minCount = Math.min(minCount, dp[i - j * j]);
            }
            // 2.3 最终f[i] = 最小的f[i-j²] + 1（+1是加上j²这个平方数）
            dp[i] = minCount + 1;
        }
        // 3. f[n]就是组成n的最少平方数数量
        return dp[n];
    }
}
