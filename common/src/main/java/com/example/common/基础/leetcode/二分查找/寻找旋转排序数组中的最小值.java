package com.example.common.基础.leetcode.二分查找;

import java.util.Arrays;

/*
 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 */
public class 寻找旋转排序数组中的最小值 {

    public static void main(String[] args) {
        System.out.printf("\n" + findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.printf("\n" + findMin1(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.printf("\n" + findMin2(new int[]{3, 1, 2}));

    }

    //solution1 暴力
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        return Arrays.stream(nums).min().getAsInt();
    }
   /*
     findmind1 和findmin2 区别如下
     findmin1 是遍历所有分段，记录最小值 是可以用while(left<= right)  逻辑是 “找最小值” 而非 “找位置”，相等时仍能有效更新 min，且边界收缩不会越界
              findMin1 的核心是通过二分遍历旋转数组的左 / 右段，不断更新最小值候选，而非 “收敛到某个位置”。
     findMin2  只能用left<right 因为这里是找位子 相等时会多执行一次导致结果不对
     findMin2 的核心是通过收缩边界，让 left 和 right 最终收敛到最小值的索引，而非 “遍历找最小值”。
    */

    //二分法「遍历型二分（找最小值候选）」
    public static int findMin1(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[0] <= nums[mid]) { //那么一定是在左边区域
                min = Math.min(min, nums[0]);
                left = mid + 1;// 去右段找更小值
            } else { //一定在右边区域
                min = Math.min(min, nums[mid]);
                right = mid - 1;// 去右段更左侧找更小值
            }
        }
        return min;
    }


    //二分法减少循环次数 旋转数组分为「左升序段」和「右升序段」，最小值一定在「右段的第一个位置」；
    /*「收敛型二分（找最小值位置）」
      注意这里千万不能用left<= right  因为当 1=1 的时候 这里 left=1+1 会导致右边移动了一位  当相等说明已经是最少得值了
     */
        public static int findMin2(int[] nums) {
            if (nums == null || nums.length == 0) return -1;
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] <= nums[right]) { //那么一定是在右边区域  这里< or <=都没有关系
                    right = mid;
                } else { //一定在左边区域 nums[mid]>= nums[right]
                    left = mid + 1;
                }
            }
            return nums[left];
        }
}
