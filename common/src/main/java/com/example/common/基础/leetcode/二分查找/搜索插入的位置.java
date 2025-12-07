package com.example.common.基础.leetcode.二分查找;

public class 搜索插入的位置 {
    public static void main(String[] args) {
        System.out.printf("" + searchInsert(new int[]{1, 3, 5, 7}, 2));
    }


    /*
     插入位置的本质 = 数组中第一个大于等于 target 的元素的下标：
     */
    public static int searchInsert(int[] nums, int target) {
        // 二分查找核心循环（左闭右闭区间 [left, right]）
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;//当 target 比数组中所有元素都大时，插入位置是数组末尾（下标 n），因此初始值设为 n 可覆盖这种边界情况。
        while (left <= right) {
            // 计算中间下标：等价于 (left + right) / 2，但避免溢出 + 位运算更快
            int mid = left + (right - left) / 2;  //        int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid; // 记录可能的插入位置（当前mid是候选）
                right = mid - 1; // 缩小右边界，找更靠左的候选位置
            } else {
                left = mid + 1;   // target > nums[mid]，需要找右半区
            }
        }
        return ans;// 返回最终的插入位置
    }

    //solution2 这个更容易理解  排序数组和  但是超过时间限制
    public int searchInsert1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 第一步：找target是否存在
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid; // 找到直接返回
            else if (nums[mid] < target) left = mid + 1;  //那就是在左边区域
            else right = mid - 1;
        }
        // 第二步：不存在则返回left（此时left > right，left就是插入位置）
        return left;
    }
}