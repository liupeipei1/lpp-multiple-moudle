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
       // System.out.printf("\n" + searchMatrix(a, 3));
        System.out.printf("\n" + searchMatrix1(a, 13));
        System.out.printf("\n" + searchMatrix3(a, 13));


    }


    //solution1 因为数组已经按照从大到小的顺序排列了
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
        int indexRow = binarySearchFirstColumn(matrix, target);
        if (indexRow < 0) return false;
        return binarySearchRow(matrix[indexRow], target);
    }

    //查找目标值可能存在的行 直到 low == high（此时范围只剩一个元素，就是我们要找的目标行）；
    public static int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1, high = matrix.length - 1;//low 初始化为 -1 并非直接 “避免死循环”，而是为了适配 “找最后一个满足条件行” 的边界逻辑
        while (low < high) { //找到矩阵中最后一个满足条件的元素 而是用low< high 而不是low<=high 可能陷入死循环（比如 low=2, high=2 时，mid=2，若满足条件，low=mid=2，循环永远不终止）。
            int mid = (high - low+1) / 2 + low;
            if (matrix[mid][0] <= target) {
                low = mid; //说明目标可能在当前行或更下方，更新low = mid；
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    //核心原因是它的目标是在单行有序数组中 “找到任意一个匹配的 target”（找到即返回，未找到则明确无匹配）
    public static boolean binarySearchRow(int[] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int low = 0;
        int high = matrix.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; //等价于low + ((high - low) >> 1)  注意位运算符优先级低于加减
            if (matrix[mid] == target) {
                return true;
            } else if (matrix[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    //二分查找
    public static boolean searchMatrix3(int[][] matrix, int target) {
        if (matrix == null || matrix[0].length <= 0)
            return false;
        int row = findRow(matrix, target);
        if (row < 0)
            return false;
        return findColumn(matrix[row], target);

    }

    //找到矩阵最后一个满足条件的行
    public static int findRow(int[][] matrix, int target) {
            int low = -1; //low 初始化为 -1 并非直接 “避免死循环”，而是为了适配 “找最后一个满足条件行” 的边界逻辑 如果把 low 初始化为 0，会直接破坏这个语义，进而导致死循环或结果错误
        int high = matrix.length - 1;
        while (low < high) {//low=high=0，循环终止
            int mid = low + (high - low+1) / 2;
            if (matrix[mid][0] <= target) {
                low = mid; //那么目标在下面区域 可以去掉上面区域
            } else { //当大于target那么 目标值在上面区域
                high = mid - 1;
            }
        }
        return low;
    }

    public static boolean findColumn(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
        //全部遍历
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {//那么就在右边
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}
