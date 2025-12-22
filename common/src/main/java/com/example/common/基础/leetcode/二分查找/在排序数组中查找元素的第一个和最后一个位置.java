package com.example.common.基础.leetcode.二分查找;

/*
给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回 [-1, -1]。
你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8, 10};
        int[] nums1 = {1};
        int target = 8;
        int[] rs = searchRange(nums1, 1);
        for (int i = 0; i < rs.length; i++) {
            System.out.printf("" + rs[i]);
        }
    }


    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int[] result = new int[2];
        result[0] = binarySearch(nums, target, true);
        result[1] = binarySearch(nums, target, false);
        return result;
    }

    public static int binarySearch(int[] nums, int target, boolean findFirst) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;// 找到目标值，先记录当前位置
                if (findFirst) {
                    right = mid - 1;// 找第一个：继续向左找更小的索引
                } else {
                    left = mid + 1;// 找最后一个：继续向右找更大的索引
                }
            } else if (nums[mid] > target) {//at left area
                right = mid - 1; // 目标值在右侧，向右收缩
            } else {
                left = mid + 1;  //at right area // 目标值在右侧，向右收缩
            }
        }
        return ans;
    }
}
