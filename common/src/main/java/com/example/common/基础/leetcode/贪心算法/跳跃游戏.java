package com.example.common.基础.leetcode.贪心算法;

import java.util.ArrayList;
import java.util.List;

/*
 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
示例 1：
输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 */
public class 跳跃游戏 {

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4}; // 预期true
        int[] nums2 = {3, 2, 1, 0, 4}; // 预期false
        System.out.println("\n" + canJump(nums1)); // 输出true
        System.out.println("\n" + canJump(nums2)); // 输出false
        System.out.println("\n" + canJump1(nums1)); // 输出true
        System.out.println("\n" + canJump1(nums2)); // 输出false
    }

    /*
    lc 会超出时间限制 当数量过大的时候
     */
    @Deprecated
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true; // 特殊情况：数组只有1个元素，已经在终点
        return dfs(nums, 0);        // 使用DFS，初始位置是0，目标是到达最后一个索引
    }

    /*计算符合的step
            2-> 1,2
            3-> 3,2,1
            1-> 1
            1->1
            4-> 1,2,3,4
    */
    public static boolean dfs(int[] nums, int index) {
        // 终止条件1：到达或超过最后一个索引，成功
        if (index >= nums.length - 1) return true;
        // 终止条件2：当前位置能跳的步数为0，无法继续，失败
        if (nums[index] == 0) {
            return false;
        }
        // 遍历当前位置能跳的所有步数（从1到nums[index]）
        for (int step = 1; step <= nums[index]; step++) {
            // 递归跳step步后的位置，只要有一条路径成功就返回true
            if (dfs(nums, index + step)) { //当前位置 + 跳的步数
                return true;
            }
        }
        // 所有步数都尝试过，都无法到达终点，返回false
        return false;
    }

    /*
      贪心算法
      只要判断最远的距离是否能到达 只要判断每一个位置是否是小于i的 只有大于i才能走到
     */
    public static boolean canJump1(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        if (nums.length == 1) return true;
        int maxFurthest = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 如果当前索引超过了能到达的最远位置，说明无法到达这里，返回false
            if (i > maxFurthest) {
                return false;
            }
            // 更新能到达的最远位置
            maxFurthest = Math.max(maxFurthest, i + nums[i]);
            // 提前终止：已经能到达最后一个索引
            if (maxFurthest >= len - 1) return true;
        }
        return false;
    }
}