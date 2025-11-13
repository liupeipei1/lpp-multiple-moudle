package com.example.common.基础.leetcode;

/*
    给你一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    子数组 是数组中的一个连续部分。
 */
public class 最大子数组和 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray1(nums));

    }

    /*  动态规划解法
     currentSum 表示以当前位置为结尾的最大子数组和。
    每步用 Math.max(nums[i], currentSum + nums[i]) 决定是把当前元素接到之前的子数组后面，还是从当前元素重新开始。
    maxSum 是到目前为止遇到的全局最大子数组和，每步用 Math.max(maxSum, currentSum) 更新。
    初始值用 nums[0] 可以正确处理全为负数的情况（如果用了 0 作为初始值，会错误地把空子数组当作候选）。
    空或 null 时返回 0 是一种防御式处理，避免空指针；根据题目要求也可以改为抛异常或其他约定。
    算法时间复杂度 O(n)，额外空间 O(1)。这就是经典的 Kadane 算法。
    best solution
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]); //决定是把当前元素接到之前的子数组后面，还是从当前元素重新开始
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    /*
      返回最大和的子数组  以及和
     */
    public static int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int currentSum = nums[0];
        int start = 0, end = 0, tempStart = 0;
        for (int i = 1; i < nums.length; i++) {
            if (currentSum + nums[i] < nums[i]) {
                currentSum = nums[i];
                tempStart = i;
            } else {
                currentSum = currentSum + nums[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }
        // 输出最大和的子数组
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = start; i <= end; i++) {
            sb.append(nums[i]);
            if (i < end) sb.append(", ");
        }
        sb.append(']');
        System.out.println("max subarray: " + sb);
        return maxSum;
    }
}
