package com.example.common.基础.leetcode;

/*
 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
注意：这里对应的answer下标要和nums下标一致
 */
public class 除自身以外数组的乘积 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int length = nums.length;
        int[] result = new int[length];

        int[] L = new int[length]; //左侧乘积  当前元素左侧的乘积 当nums第一个数时  L[0] =1
        int[] R = new int[length]; //左侧乘积  当nums最后一个数时 R[n-1] =1
        L[0] = 1;
        R[length - 1] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = L[i - 1] * nums[i - 1]; //這樣就可以得到左侧的乘积 L[i]对应的是前面的累乘机
        }
        for (int i = length - 2; i >= 0; i--) { //從右邊開始累乘  这里是length-2 因为最后一个数R[length-1]已经初始化为1了
            R[i] = R[i + 1] * nums[i + 1]; //這樣就可以得到右侧的乘积 R[i]对应的是后面的累乘机
        }

        for (int i = 0; i < length; i++) {
            result[i] = L[i] * R[i];
        }
        return result;
    }
}
