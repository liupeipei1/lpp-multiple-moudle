package com.example.common.基础.leetcode.动态规划;

/*
 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。
 */
public class 最小路径和 {
    public static void main(String[] args) {
        最小路径和 solution = new 最小路径和();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int result = solution.minPathSum(grid);
        System.out.println(result); // 输出: 7
    }

    /*
动态规划 定义一个二维数组 dp，其中 dp[i][j] 表示从左上角 (0, 0) 到位置 (i, j) 的最小路径和。
初始化：dp[0][0] = grid[0][0]，第一行和第一列的路径和可以通过累加前一个位置的值来初始化，因为只能向右或向下移动。
状态转移方程：对于其他位置 (i, j)，最小路径和等于当前位置的值加上从上方位置 (i-1, j) 和左方位置 (i, j-1) 的最小路径和的较小者，
即 dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])。
最终结果：返回 dp[m-1][n-1]，即到达右下角位置的最小路径和。
复杂度分析：
时间复杂度：O(m*n)，需要填充整个 dp 数组。
空间复杂度：O(m*n)，用于存储 dp 数组。
      你可以直接看成最后一个方格，然后到它只能是左边方格 和上面的方格，只要算出来这两个方格最小值即可得出来
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n]; //保存每一个位置的最小路径和
        dp[0][0] = grid[0][0]; //起点位置的路径和就是它本身
        //初始化第一列的路径和，因为只能向下移动
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        //初始化第一行和第一列的路径和，因为只能向右或向下移动
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);  //要么向下 要么向右取最小值
            }
        }
        return dp[m - 1][n - 1];
    }
}
