package com.example.common.基础.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

/*
 The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement,
where 'Q' and '.' both indicate a queen and an empty space, respectively.
皇后在同一行 或者同一列会相互攻击   所以实现皇后在棋牌不会相互攻击的情况
要求任意两个皇后不能处于同一行、同一列或同一对角线上（即互不攻击）。
 */

public class n皇后1 {
    public static void main(String[] args) {
        List<List<String>> rs = solveNQueens(4);
        for (List<String> r : rs) {
            System.out.printf("" + r);
        }
    }

    /**
     * N 皇后问题的核心约束：
     * 每行只能放 1 个皇后（因此可以按行遍历，每行只选一列放置）
     * 每列只能放 1 个皇后
     * 两条对角线（左上→右下、右上→左下）只能放 1 个皇后
     * 主方法：求解N皇后问题
     *
     * @param n 棋盘大小（N×N）
     * @return 所有合法的棋盘配置
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n == 0) return result;
        int[] queens = new int[n];// 索引代表 行号  值代表列号
        dfs(queens, 0, n, result);
        return result;
    }

    public static void dfs(int[] queens, int beginIndex, int len, List<List<String>> result) {
        if (beginIndex == len) {
            result.add(convert(queens, len));  //将皇后转化成数组
            return;
        }
        for (int col = 0; col < len; col++) {
            //判断是否存在攻击
            if (isValid(beginIndex, col, queens)) {
                // 放置皇后：记录当前行的皇后列位置
                queens[beginIndex] = col;
                // 递归处理下一行
                dfs(queens, beginIndex + 1, len, result);
                // 回溯：无需显式删除，下一次循环会覆盖当前值
            }
        }
    }

    /**
     * 将皇后位置转换为棋盘字符串（每行是一个字符串）
     *
     * @param queens 每行皇后的列位置
     * @param n      棋盘大小
     * @return 棋盘配置的字符串列表
     */
    public static List<String> convert(int[] queens, int n) {
        List<String> rs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] rowChars = new char[n];
            // 初始化当前行为全'.'
            for (int j = 0; j < n; j++) {
                rowChars[j] = '.';
            }
            // 将皇后位置设为'Q'
            rowChars[queens[i]] = 'Q';
            rs.add(new String(rowChars));
        }
        return rs;
    }

    /**
     * 检查当前位置(row, col)是否可以放置皇后
     *
     * @param row    当前行
     * @param column 当前列
     * @param queens 已放置的皇后位置
     * @return true=合法，false=不合法
     */
    public static boolean isValid(int row, int column, int[] queens) {
        // 检查已放置的所有行（0 ~ row-1）
        for (int i = 0; i < row; i++) {
            int c = queens[i]; //queen所在的行的column
            // 冲突条件1：同一列
            if (c == column) return false;
            // 冲突条件2：同一对角线（左上→右下）：行差=列差 注意这里需要绝对值  row肯定是大于i的
            if (row - i == Math.abs(column - queens[i])) return false;
        }
        return true;
    }


}
