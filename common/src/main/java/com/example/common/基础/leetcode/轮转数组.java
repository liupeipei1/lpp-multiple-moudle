package com.example.common.基础.leetcode;

import static org.apache.commons.lang3.ArrayUtils.reverse;

/*
给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class 轮转数组 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        //两种方法都可以
        rotate2(nums, k);
        rotate(nums, k);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return;
        }
        int[] rs = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {//从最右边的元素开始移动  或者从从左边开始移动都可以
            int newIndex = (i + k) % nums.length; //计算新位置
            //临时变量保存当前位置的值
            int temp = nums[i];
            //将当前位置的值移动到新位置
            rs[newIndex] = temp;
        }
        System.arraycopy(rs, 0, nums, 0, nums.length);
        /*
         // 错误：只改变了方法内的引用，调用方的数组不受影响
        nums = rs;

        // 正确：把 rs 的内容复制回原数组，使调用方可见
        System.arraycopy(rs, 0, nums, 0, nums.length);
         */
    }

    public static void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return;
        }
        int n = nums.length;
        k = k % n; //处理k大于数组长度的情况
        reverse(nums, 0, n - 1); //整体反转
        reverse(nums, 0, k - 1); //反转前k个元素
        reverse(nums, k, n - 1); //反转剩余元素
    }
}
