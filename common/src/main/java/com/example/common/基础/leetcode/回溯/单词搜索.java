package com.example.common.基础.leetcode.回溯;

/*
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class 单词搜索 {

    public static void main(String[] args) {
        char[][] chars = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] chars1 = {{'a', 'a'}};
        char[][] chars2 = {{'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}};

        System.out.printf("" + exist(chars1, "aaa"));

    }


    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // 遍历每个起点
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 找到第一个字符匹配的位置，启动DFS
                if (dfs(board, word, i, j, 0, visited)) {
                    return true; // 找到路径直接返回true
                }
            }
        }
        return false; // 所有起点都遍历完仍未找到
    }

    /**
     * 深度优先搜索 + 回溯
     *
     * @param board   字符矩阵
     * @param word    目标单词
     * @param x       当前行
     * @param y       当前列
     * @param index   当前匹配到的单词索引
     * @param visited 访问标记数组
     * @return 是否找到有效路径
     */
    private static boolean dfs(char[][] board, String word, int x, int y, int index, boolean[][] visited) {
        // 终止条件1：匹配完所有字符（找到有效路径）
        if (index == word.length()) {
            return true;
        }
        // 终止条件2：越界/已访问/当前字符不匹配
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length
                || visited[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }

        // 做选择：标记当前位置已访问
        visited[x][y] = true;

        // 遍历上下左右四个方向
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            // 递归搜索下一个字符，只要有一个方向找到就返回true
            if (dfs(board, word, nx, ny, index + 1, visited)) {
                return true;
            }
        }
        // 回溯：撤销选择（当前路径走不通，释放当前位置）
        visited[x][y] = false;

        // 所有方向都走不通，返回false
        return false;
    }
}
