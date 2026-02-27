package com.example.common.基础.leetcode.技巧;

/*
 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class 寻找重复数字 {

    public static void main(String[] args) {
        寻找重复数字 solution = new 寻找重复数字();
        int[] nums = {1, 3, 4, 2, 2};
        int result = solution.findDuplicate(nums);
        System.out.println(result); // 输出: 2
    }


    //因为题目要求 数组的值不能超过数组长度 并且只存在一个重复的数字
    public int findDuplicate(int[] nums) {
        int left = 1; //数组值最小值
        int right = nums.length - 1; //这里其实就是以数值范围为边界进行二分查找  因为题目要求 数组的值不能超过数组长度 并且只存在一个重复的数字
        while (left < right) {
            /*
             left = 2**30
              right = 2**30 + 1
              如果单独用 (left+right)/2 就会存在上面的情况  因为left+right会超过整数范围  导致溢出  所以需要用 left + (right - left) / 2 来避免整数溢出
             */
            int mid = left + (right - left) / 2; //避免整数溢出
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) { //说明重复的数字在左半部分
                right = mid;
            } else { //说明重复的数字在右半部分
                left = mid + 1;
            }
        }
        return left;
    }

}
