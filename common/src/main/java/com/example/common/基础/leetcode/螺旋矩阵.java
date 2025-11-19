package com.example.common.基础.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
    输入：matrix =
    [[1,2,3],
    [4,5,6],
    [7,8,9]]
    输出：[1,2,3,6,9,8,7,4,5]
 */
public class 螺旋矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix1 = {
                {6, 9, 7}
        };
        int[] result = spiralOrder(matrix1);
        for (int num : result) {
            System.out.print(num + " ");
        }
        List<Integer> result1 = spiralOrder1(matrix1);
        System.out.println("\n");
        for (int num : result1) {
            System.out.print(num + " ");
        }


    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[rows * cols];
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        int index = 0;
        while (left <= right && top <= bottom) {
            // Traverse from left to right
            for (int col = left; col <= right; col++) {
                result[index++] = matrix[top][col];
            }
            top++;

            // Traverse from top to bottom   //将最左边的数据添加数组 从上到下遍历
            for (int row = top; row <= bottom; row++) {
                result[index++] = matrix[row][right];
            }
            right--;

            if (top <= bottom) {
                // Traverse from right to left
                for (int col = right; col >= left; col--) {
                    result[index++] = matrix[bottom][col];
                }
                bottom--;
            }

            if (left <= right) {
                // Traverse from bottom to top
                for (int row = bottom; row >= top; row--) {
                    result[index++] = matrix[row][left];
                }
                left++;
            }
        }
        return result;
    }

    public static List<Integer> spiralOrder1(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return new ArrayList<>();
        }

        int rows = matrix.length;
        int colums = matrix[0].length;
        int left = 0;
        int right = colums - 1;
        int top = 0;
        int bottom = rows - 1;

        List<Integer> rs = new ArrayList<>();
        while (left <= right  &&  top <= bottom) {
            //从左边到右边
            for (int i = left; i <= right; i++) {
                rs.add(matrix[top][i]);
            }
            top++; //第一行进行添加

            //将最左边的数据添加数组 从上到下遍历
            if (top <= bottom) {
                for (int i = top; i <= bottom; i++) {
                    rs.add(matrix[i][right]);
                }
            }
            right--; //因为最左边数据少一列 那么需要--
            //从最右边到最左边
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    rs.add(matrix[bottom][i]);
                }
                bottom--;
            }
            //bottom to top 从左边到右边
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    rs.add(matrix[i][left]);
                }
                left++;
            }
        }
        return rs;
    }
}
