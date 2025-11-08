package com.example.common.基础.leetcode;

/*
 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
返回 滑动窗口中的最大值 。
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 */
public class 滑动窗口最大的值 {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] nums1 = {1, -1};
        int k1 = 1;
        int[] result = maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " \n");
        }

        int[] result1 = maxSlidingWindow(nums1, k1);
        for (int num : result1) {
            System.out.print(num + " ");
        }
    }

    /*  暴力解法  时间复杂度O(n*k)  空间复杂度O(1)
        超过了最大的时间限制  不推荐
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {//因为存在k的窗口长度  后面面就不需要再循环了
            int max = Integer.MIN_VALUE;
            //int[] temp = new int[k];
            for (int j = i; j < i + k; j++) {
                //temp[j - i] = nums[j];
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            result[i] = max;
        }
        return result;
    }
}
