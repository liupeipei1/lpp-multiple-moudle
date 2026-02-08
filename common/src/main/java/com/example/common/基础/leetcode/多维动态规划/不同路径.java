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
        System.out.println(solution.uniquePathsOptimize(3, 7)); // 输出: 28
        System.out.println(solution.uniquePathsOptimizeOptimize(3, 7)); // 输出: 28

    }


    /*
    最容易理解的方式是使用动态规划来解决这个问题。我们可以定义一个二维数组 dp，其中 dp[i][j] 表示从起点 (0, 0) 到达位置 (i, j) 的不同路径数量。
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

    // 空间优化DP解法（一维数组）
    /*
    观察到在计算 dp[i][j] 时，我们只需要 dp[i-1][j]（上一行同一列）和 dp[i][j-1]（当前行前一列）的值。因此，我们可以使用一个一维数组来优化空间复杂度。
    优化思路：
    使用一个长度为 n 的一维数组 dp，其中 dp[j] 表示当前行的第 j 列的路径数量。
    初始化：将 dp 数组初始化为 1，因为第一行的路径数为 1。
    状态转移方程：对于每一行，从第二行开始，更新 dp[j] 的值为 dp[j] + dp[j - 1]，其中 dp[j]（原来的值）表示上一行同一列的路径数，dp[j - 1] 表示当前行前一列的路径数。
    最终结果：返回 dp[n - 1]，即到达右下角位置的路径数量。
    复杂度分析：
    时间复杂度：O(m*n)，需要遍历整个网格。
    空间复杂度：O(n)，用于存储一维 dp 数组。
     */
    public int uniquePathsOptimize(int m, int n) {
        // 只用一维数组，初始化为1（对应第一行的边界条件）
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }

        // 遍历每一行（从第二行开始）
        for (int i = 1; i < m; i++) {
            // 遍历每一列（从第二列开始）
            for (int j = 1; j < n; j++) {
                // dp[j] = 原来的dp[j]（上一行当前列） + dp[j-1]（当前行前一列）
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }
    /*
    组合数学解法
    观察到从起点 (0, 0) 到达终点 (m-1, n-1) 的路径总是由 m-1 次向下移动和 n-1 次向右移动组成。因此，总的移动次数为 (m-1) + (n-1) = m + n - 2。
    在这 m + n - 2 次移动中，我们需要选择其中的 m - 1 次向下移动（或者 n - 1 次向右移动）。这实际上是一个组合问题，可以使用组合数公式来计算路径数量。
    组合数公式：C(m+n-2, m-1) 或 C(m+n-2, n-1)，其中 C(a, b) = a! / (b! * (a - b)!)
    复杂度分析：
    时间复杂度：O(min(m, n))，计算组合数时需要进行一些乘法和除法操作，具体取决于 m 和 n 的大小。
    空间复杂度：O(1)，只需要常数空间来存储计算结果。
直接计算组合数
C
m+n−2
min(m−1,n−1)
，避免循环，效率最高：
     */
    public int uniquePathsOptimizeOptimize(int m, int n) {
        int N = m + n - 2; // 总的移动次数
        int k = Math.min(m - 1, n - 1); // 选择较小的移动次数，优化计算
        long res = 1; // 使用 long 类型避免中间结果溢出

        // 计算组合数 C(N, k) = N! / (k! * (N - k)!)
        for (int i = 1; i <= k; i++) {
            res = res * (N - k + i) / i; // 等价于 res *= (N - k + i) / i
        }

        return (int) res;

    }
}
