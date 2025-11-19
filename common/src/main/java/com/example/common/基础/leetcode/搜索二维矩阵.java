package com.example.common.基础.leetcode;

/*
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
判断这个元素是否存在
 */
public class 搜索二维矩阵 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.printf("直接查找方法：" + solve(nums, 5));
        System.out.printf("\n二分查找：" + solve1(nums, 5));
        System.out.printf("\nZ型查找：" + solve2(nums, 5));


    }

    //方法一：直接查找
    public static boolean solve(int[][] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    //方法二：二分查找
    public static boolean solve1(int[][] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        for (int[] num : nums) {
            int index = find(num, target);
            if (index != -1) {
                return true;
            }
        }
        return false;
    }

    public static int find(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; //找到中间的下标
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;//缩小循环的窗口 将最大的值往里面缩小
            } else if (nums[mid] < target) {
                low = mid + 1; //将最小的值往右缩小
            }
        }
        return -1;
    }

    /*
    方法三： Z子型查找
     我们可以从矩阵 matrix 的右上角 (0,n−1) 进行搜索。在每一步的搜索过程中，如果我们位于位置 (x,y)，
     那么我们希望在以 matrix 的左下角为左下角、以 (x,y) 为右上角的矩阵中进行搜索，即行的范围为 [x,m−1]，列的范围为 [0,y]：
     */
    public static boolean solve2(int[][] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int m = nums.length;
        int n = nums[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (nums[x][y] == target) {
                return true;
            }
            if (nums[x][y] > target) {
                y--;
            }
            if (nums[x][y] < target) {
                x++;
            }
        }
        return false;
    }

}
