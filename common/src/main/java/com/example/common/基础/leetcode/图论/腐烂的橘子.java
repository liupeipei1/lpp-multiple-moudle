package com.example.common.基础.leetcode.图论;

import java.util.LinkedList;
import java.util.Queue;

/*
 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：

值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 */
public class 腐烂的橘子 {
    public static void main(String[] args) {
        System.out.printf("" + orange(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.printf("\n" + orange(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));

    }

    //输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
    //输出：4  需要四分钟才能拿个全部腐烂掉
    /*
      思路：统计多少个腐烂的橘子  多少个新鲜的橘子
      将腐烂的橘子放在队列里面
      腐烂的范围是往四周扩散   那么x 四周的坐标
      [[-1,0],[1,0],[0,1],[0,-1]]

     */
    public static int orange(int[][] grids) {
        if (grids == null || grids.length == 0)
            return -1;

        int row = grids.length;
        int col = grids[0].length;
        int refreshOrange = 0; //新鲜的橘子
        Queue<int[]> queue = new LinkedList<>(); //记录腐烂的橘子的位置
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grids[i][j] == 1) {
                    refreshOrange++;
                } else if (grids[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        // 边界情况：没有新鲜橘子，直接返回0
        if (refreshOrange == 0)
            return 0;
        int[][] positions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};//上下右左
        int minute = 0;
        while (!queue.isEmpty() && refreshOrange > 0) {
            minute++;
            int size = queue.size();
            for (int i = 0; i < size; i++) { // 处理当前层的所有腐烂橘子
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                //传染给周围的新鲜的橘子
                for (int[] position : positions) {
                    int nx = x + position[0];
                    int ny = y + position[1];  //得到需要传染给周围的坐标
                    if (nx >= 0 && ny >= 0 && nx < row && ny < col && grids[nx][ny] == 1) {//控制坐标 + 保证这个位置的橘子是新鲜的
                        grids[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                        refreshOrange--;
                    }
                }
            }
        }
        // 第三步：结果判断
        // 若新鲜橘子全部被感染，返回耗时；否则返回-1
        return refreshOrange == 0 ? minute : -1;
    }
}
