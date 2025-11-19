package com.example.common.基础.leetcode;

import java.util.Arrays;

/*
给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[[7,4,1],[8,5,2],[9,6,3]]
我们将其翻译成代码。由于矩阵中的行列从 0 开始计数，因此对于矩阵中的元素 matrix[row][col]，在旋转后，它的新位置为 matrix new[col][n−row−1] 。
 */
public class 旋转图像 {
    public static void main(String[] args) {

        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
       spiralVertical(nums);
        System.out.println(Arrays.deepToString(nums));

        int[][] nums1 =
                {{5, 1, 9, 11},
                        {2, 4, 8, 10},
                        {13, 3, 6, 7},
                        {15, 14, 12, 16}};
        spiralVertical(nums1);
        System.out.println(Arrays.deepToString(nums1));

    }

    /*
    垂直旋转
        0 0 -   0 3
        0 1     1,3
        0 2     2,3
        0,3     3,3
     */
    public static void spiralVertical(int[][] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int length = nums.length;
        int[][] rs = new int[length][length];
        for (int i = 0; i < length; i++) { //row
            for (int j = 0; j < length; j++) { //colum
                rs[j][length - 1 - i] = nums[i][j];
            }
        }
        System.arraycopy(nums, 0, rs, 0, length);
    }
}
