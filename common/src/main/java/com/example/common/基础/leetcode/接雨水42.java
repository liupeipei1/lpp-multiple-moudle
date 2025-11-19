package com.example.common.基础.leetcode;

public class 接雨水42 {
    public static void main(String[] args) {
            int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    //双指针的方式
    public static int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int leftMax = 0,rightMax = 0;//记录左右两边的最大值
        int left = 0,right = height.length - 1;
        int area = 0;
        //便利数组
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]); //更新左边最大值
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                area += leftMax - height[left];  //将左边最大的值减去 当前值 就是可以接的雨水
                left++;
            } else {
                area += rightMax - height[right];
                right--;
            }
        }

        return area;
    }
}

