package com.example.common.基础.leetcode.动态规划;

/*
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class 打家窃舍 {
    public static void main(String[] args) {
        打家窃舍 solution = new 打家窃舍();
        //System.out.printf("\n" + solution.rob(new int[]{1, 2, 3, 1}));//4
       // System.out.printf("\n" + solution.rob(new int[]{2, 7, 9, 3, 1}));//12
      //  System.out.printf("\n" + solution.rob(new int[]{2, 1, 1, 2}));//12
        System.out.printf("\n" + solution.rob1(new int[]{2, 7, 9, 3, 1}));//12
        System.out.printf("\n" + solution.rob1(new int[]{2, 1, 1, 2}));//4

    }

    //保证不触动警报装置的情况下，偷窃到的最高金额 数组的值对应的是每一个房间对应的金额 也可以跳多个房间 所以不能局限奇数和偶数区
    //动态规划 找到每一个位置的最大值
    public int rob1(int[] nums) {
        if (nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        int[] dp = new int[n]; //保存每一个房间对应的最大的累积值
        dp[0] = nums[0]; //只有一件 // 第1间，只能抢
        dp[1] = Math.max(nums[0], nums[1]);//两件房子只能抢一个
        //找到第二个位置开始的最大值
        for (int i = 2; i < n; i++) {
            //当前i位置最大的值  =  前i-2位置的最大值 + 当前值i  和  前i-1位置的最大值  取最大值
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n-1];
    }
}
