package com.example.common.基础.leetcode.二分查找;

/*
  整数数组 nums 按升序排列，数组中的值 互不相同 。
在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 向左旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 下标 3 上向左旋转后可能变为 [4,5,6,7,0,1,2] 。
给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。

注意首先给函数前这个nuns已经变成两个升序的数组了 所以这里用二分查找的方式就得找是在哪个区域
 */
public class 搜索旋转排序数组 {

    public static void main(String[] args) {
        System.out.printf(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0) + "\n");
        System.out.printf(search1(new int[]{4, 5, 6, 7, 0, 1, 2}, 0) + "\n");

    }


    //solution 1暴力破解法
    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }

    //旋转的数字分成两个小升序的数组  只要找到最小的数在哪个位置就可以确定在哪个区域了
    /*
     如果 [l, mid - 1] 是有序数组，且 target 的大小满足 [nums[l],nums[mid])，
     则我们应该将搜索范围缩小至 [l, mid - 1]，否则在 [mid + 1, r] 中寻找。
     如果 [mid, r] 是有序数组，且 target 的大小满足 [nums[mid+1],nums[r]]，
     则我们应该将搜索范围缩小至 [mid + 1, r]，否则在 [l, mid - 1] 中寻找。
     数组整体可分为左升序段和右升序段（如 [4,5,6,1,2,3] → 左段 [4,5,6]，右段 [1,2,3]）；
     */
    public static int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int ans = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 核心1：找到目标值，直接返回
            if (nums[mid] == target) {
                ans = mid;
                return ans;
            }
            // 核心2：判断mid落在左升序段还是右升序段
            if (nums[0] <= nums[mid]) {  //左边的升序
                if (nums[0] <= target && target <= nums[mid]) {// 目标值在左段的升序范围内 → 收缩右边界
                    right = mid - 1;
                } else {// 目标值不在左段 → 收缩左边界，去右段找
                    left = mid + 1;
                }
            } else {  // 右段升序（mid在右段）
                if (nums[mid] <= target && target <= nums[nums.length - 1]) {// 目标值在右段的升序范围内 → 收缩左边界
                    left = mid + 1;
                } else { // 目标值不在右段 → 收缩右边界，去左段找
                    right = mid - 1;
                }
            }
        }
        return ans;
    }


    //二分法2
    public static int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid; // 找到直接返回，省略ans变量
            // 核心：合并升序段判断 + 范围收缩逻辑
            // 情况1：左段升序 且 目标在左段 → 右边界左移；否则左边界右移
            // 情况2：右段升序 且 目标不在右段 → 右边界左移；否则左边界右移
            if ((nums[0] <= nums[mid] && nums[0] <= target && target < nums[mid])
                    || (nums[0] > nums[mid] && !(nums[mid] < target && target <= nums[nums.length - 1]))) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1; // 无需ans，直接返回-1
    }
}
