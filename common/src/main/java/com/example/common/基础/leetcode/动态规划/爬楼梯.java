package com.example.common.基础.leetcode.动态规划;

import java.util.ArrayList;
import java.util.List;

/*
 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶
示例 2：
输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶
 */
public class 爬楼梯 {

    public static void main(String[] args) {
        System.out.printf("\n" + climbStairs(2));//2
        System.out.printf("\n" + climbStairs(3));//3
        System.out.printf("\n" + climbStairs(4));//5
        System.out.printf("\n" + climbStairs(5));//8
        System.out.printf("\n" + climbStairs(35)); //14930352

        System.out.printf("============== \n");
        System.out.printf("\n" + climbStairs2(2));//2
        System.out.printf("\n" + climbStairs2(3));//3
        System.out.printf("\n" + climbStairs2(4));//5
        System.out.printf("\n" + climbStairs2(5));//8
        System.out.printf("\n" + climbStairs2(35)); //14930352

        System.out.printf("============== \n");
        System.out.printf("\n" + climbStairs3(2));//2
        System.out.printf("\n" + climbStairs3(3));//3
        System.out.printf("\n" + climbStairs3(4));//5
        System.out.printf("\n" + climbStairs3(5));//8
        System.out.printf("\n" + climbStairs3(35)); //14930352

    }


    /*
     回溯法  超出时间限制
     */
    @Deprecated
    public static int climbStairs(int n) {
        List<List<Integer>> rs = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, n, path, rs, 2);
        return rs.size();
    }

    /**
     * 回溯DFS计算所有爬楼梯的路径
     *
     * @param steps   已走的步数总和
     * @param n       目标总步数（爬n阶）
     * @param path    记录当前路径（每一步走的阶数）
     * @param rs      存储所有合法路径
     * @param maxStep 每次最多走的阶数（固定为2）
     */
    public static void dfs(int steps, int n, List<Integer> path, List<List<Integer>> rs, int maxStep) {
        if (steps == n) {
            // 关键：添加path的副本，而非引用
            rs.add(new ArrayList<>(path));//递归终止时，path 的内容是一个完整排列，通过 new ArrayList<>(path) 创建副本并加入 rs，避免后续修改 path 影响已保存的结果。
            return;
        }
        // 遍历 nums 中的每个元素
        for (int i = 1; i <= n - steps; i++) {
            if (i > maxStep) continue;
            path.add(i);
            dfs(steps + i, n, path, rs, maxStep);
            path.remove(path.size() - 1); // 回溯，移除最后添加的元素
        }
    }

    /*解决方案 从回溯 到动态规划 这个容易理解
    问题分析：
        爬到第 x 级台阶的方法数 f(x) 可以由以下两种情况推导出来：
        1. 如果最后一步是从第 x-1 级台阶爬上来的，那么在到达第 x-1 级台阶时，有 f(x-1) 种方法。
        2. 如果最后一步是从第 x-2 级台阶爬上来的，那么在到达第 x-2 级台阶时，有 f(x-2) 种方法。
        因此，爬到第 x 级台阶的方法数 f(x) 等于爬到第 x-1 级台阶的方法数加上爬到第 x-2 级台阶的方法数，即：
        f(x) = f(x-1) + f(x-2)
        初始条件：
        f(1) = 1（只有一种方法爬到第一级）
        f(2) = 2（有两种方法爬到第二级：1+1 或 2）
        综上所述，“
        每次只能爬 1 或 2 级” 就必然推导出 f(x) = f(x-1) + f(x-2)
    方案 1：基础动态规划（求 “方法数”，不记录路径）
        设 dp[i] 为爬到第 i 阶的方法数，则状态转移方程为：
        第一级：1阶只有一种方法 dp[1] = 1
        第二级：2阶有两种方法 dp[2] = 2
        第三级及以后：爬到第 i 阶的方法数等于爬到第 i-1 阶和第 i-2 阶的方法数之和，即 dp[i] = dp[i-1] + dp[i-2]
        如果可以爬三级，那么最终的公式是下面，最后一步要么是1步 要么是2步 要么是3步
        f(x) = f(x-1) + f(x-2) + f(x-3)。
     */
    public static int climbStairs2(int n) {
        if (n <= 2) return n;  //小于两级的都是 n 种方法
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /* 比较难理解
     方案 3：矩阵快速幂（高级）
        爬楼梯问题可以转化为斐波那契数列问题，
        使用矩阵快速幂可以在 O(log n) 时间内计算出结果，适用于 n 非常大的情况。
     */
    public static int climbStairs3(int n) {
        if (n <= 2) return n;  //小于两级的都是 n 种方法
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = matrixPow(q, n - 2);
        return 2 * res[0][0] + res[1][0];
    }

    public static int[][] matrixPow(int[][] matrix, int n) {
        int[][] res = {{1, 0}, {0, 1}}; // 单位矩阵
        while (n > 0) {
            if ((n & 1) == 1) {
                res = multiply(res, matrix);
            }
            n >>= 1;
            matrix = multiply(matrix, matrix);
        }
        return res;
    }

    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int a = matrix1[0][0] * matrix2[0][0] + matrix1[0][1] * matrix2[1][0];
        int b = matrix1[0][0] * matrix2[0][1] + matrix1[0][1] * matrix2[1][1];
        int c = matrix1[1][0] * matrix2[0][0] + matrix1[1][1] * matrix2[1][0];
        int d = matrix1[1][0] * matrix2[0][1] + matrix1[1][1] * matrix2[1][1];
        return new int[][]{{a, b}, {c, d}};
    }


}
