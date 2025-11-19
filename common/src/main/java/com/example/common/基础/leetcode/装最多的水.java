package com.example.common.基础.leetcode;

/*  leetcode 11
盛最多水的容器
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class 装最多的水 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea2(height));
    }


    /*
      当垂线过多 这里就会出现耗时最长
     */
    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {  //最后一个元素不需要再计算
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                int area= minHeight * (j-i);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;

    }

    public static int maxArea2(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
/*      int maxArea = 0;
        int left = 0;  //指向第一个元素 下标
        int right = height.length - 1; //指向最后一个元素  下标*/
        int maxArea = 0, left = 0,right=height.length -1;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int area = minHeight * (right - left);
            if (area > maxArea) {
                maxArea = area;
            }
            // 移动较短的边  这样得到的面积才有可能变大
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
