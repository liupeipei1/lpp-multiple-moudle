package com.example.common.基础.leetcode.二分查找;

/*
 给你一个满足下述两条属性的 m x n 整数矩阵：
每行中的整数从左到右按非严格递增顺序排列。
每行的第一个整数大于前一行的最后一个整数。
给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 */
public class 搜搜二维矩阵 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.printf("" + searchMatrix(a, 3));
        System.out.printf("\n" + searchMatrix1(a, 4));

    }


    //因为数组已经按照从大到小的顺序排列了
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int xLength = matrix.length;
        int yLength = matrix[0].length;
        for (int i = 0; i < xLength; i++) {
            int largest = matrix[i][yLength - 1];
            if (target > largest) {
            } else if (target == largest) {
                return true;
            } else if (target < largest) {
                for (int j = yLength - 1; j >= 0; j--) {
                    if (matrix[i][j] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //solution 2 二分法查找
    public static boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int indexRow = searchRow(matrix, target);
        return searchColumns(matrix[indexRow], target);
    }

    public static int searchRow(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return -1;
        int low = 0;
        int high = matrix[0].length - 1;
        while (low < high) {
            int mid = low + (high - low) >> 1; //注意这里是右移动1位 等于除以2
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static boolean searchColumns(int[] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int low = 0;
        int high = matrix.length - 1;
        while (low < high) {
            int mid = low + (high - low) >> 1;
            if (matrix[mid] == target) {
                return true;
            } else if (matrix[mid] < target) {
                low = mid + 1;
            } else if (matrix[mid] > target) {
                high = mid - 1;
            }
        }
        return false;
    }
}
