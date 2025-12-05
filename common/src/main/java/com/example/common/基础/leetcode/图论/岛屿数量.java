package com.example.common.基础.leetcode.图论;

import java.util.LinkedList;
import java.util.Queue;

/*
 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
输入：grid = [
  ['1','1','1','1','0'],
  ['1','1','0','1','0'],
  ['1','1','0','0','0'],
  ['0','0','0','0','0']
]
输出：1

这个解题思路 将周围的数据  通过上下左右的数组的方式循环 然后得到新的坐标  判断是否是陆地
当周围的都是陆地 那么循环的给覆盖成0  这样避免重复计算
 */
public class 岛屿数量 {

    public static void main(String[] args) {
        int a = numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}
                , {'0', '0', '0', '0', '0'}});
        System.out.printf("a=" + a);
    }

    /*
      用bfs 广度优先搜索  逐级搜所
     */
    public static int numIslands(char[][] grid) {
        if (null == grid || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int isIsland = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    isIsland++;
                    //bfs(grid, i, j);//可以用dfs -两种方法都支持 选择其一即可
                    dfs(grid, i, j);
                }
            }
        }
        return isIsland;
    }

    /*
       发现 '1' 时用队列存储连通陆地
       广度快速搜索 这里将第一个陆地的周边的陆地都标记给0  这样就可以连接上了
     */
    public static void bfs(char[][] grid, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int row1 = curr[0] + dir[0];
                int col1 = curr[1] + dir[1];
                if (row1 >= 0 && col1 >= 0 && row1 < grid.length && col1 < grid[0].length && grid[row1][col1] == '1') {
                    queue.offer(new int[]{row1, col1});
                    grid[row1][col1] = '0';
                }
            }
        }
    }

    //solution 2 深度快速搜索
    public static void dfs(char[][] grid, int row, int col) {
        int nr = grid.length;
        int nc = grid[0].length;

        // 递归终止条件：坐标越界 或 当前位置是海水（'0'）
        if (row < 0 || col < 0 || row >= nr || row >= nc || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
