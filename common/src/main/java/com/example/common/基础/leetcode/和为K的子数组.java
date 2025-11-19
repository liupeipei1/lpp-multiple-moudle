package com.example.common.基础.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。

子数组是数组中元素的连续非空序列。
 */
public class 和为K的子数组 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
        System.out.println(subarraySum1(nums, k));
        // System.out.println(subarraySum2(nums, k));  超时间限制了

    }

    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        //前缀和数组
        int[] prefixSums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
        //双重循环遍历所有子数组
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                if (prefixSums[end] - prefixSums[start] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /*
        优化方法 使用哈希表存储前缀和及其出现的次数
        1.初始化一个哈希表 cnt 用于存储前缀和及其出现的次数，初始时将前缀和 0 出现次数设为 1。
     */
    public static int subarraySum1(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        int sum = 0, res = 0;
        for (int x : nums) {
            sum += x;
            res += cnt.getOrDefault(sum - k, 0);//寻找之前出现过的前缀和 使得 当前前缀和 - 之前的前缀和 = k
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);//记录当前前缀和出现的次数
        }
        return res;
    }

    /*
        暴力破解法 这个方法是从每个可能的结束位置开始，向前累加子数组的和，并检查是否等于 k。 从而避免了计算所有可能的起始位置。
        但是超过时间限制  不推荐了
     */
    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

}
