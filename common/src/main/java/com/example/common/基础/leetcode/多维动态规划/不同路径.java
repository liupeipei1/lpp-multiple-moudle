package com.example.common.基础.leetcode.多维动态规划;

/*
 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
问总共有多少条不同的路径？
 */
public class 不同路径 {
    public static void main(String[] args) {
        不同路径 solution = new 不同路径();
        System.out.println(solution.uniquePaths(3, 7)); // 输出: 28
    }


    /*
    动态规划 定义一个二维数组 dp，其中 dp[i][j] 表示从起点 (0, 0) 到达位置 (i, j) 的不同路径数量。
    初始化：第一行和第一列的路径数为 1，因为机器人只能向右或
    向下移动。
    状态转移方程：对于其他位置 (i, j)，路径数等于从上方位置 (i-1, j) 和左方位置 (i, j-1) 的路径数之和，即 dp[i][j] = dp[i-1][j] + dp[i][j-1]。
    最终结果：返回 dp[m-1][n-1]，即到达右下角位置的路径数量。
    复杂度分析：
    时间复杂度：O(m*n)，需要填充整个 dp 数组。
    空间复杂度：O(m*n)，用于存储 dp 数组。
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];//保存每一个位置的路径数量
        //初始化第一行和第一列的路径数为 1，因为机器人只能向右或向下移动。
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1; //第一列的路径数为 1，因为机器人只能向下移动。
        }

        //向右边移动
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //状态转移方程：对于其他位置 (i, j)，路径数等于从上方位置 (i-1, j) 和左方位置 (i, j-1) 的路径数之和，即 dp[i][j] = dp[i-1][j] + dp[i][j-1]。
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
