package com.example.common.基础.leetcode;

import java.util.Arrays;

public class 移动零283 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 4, 3, 12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
/*
  只需要移动0 不用管其他非零元素的相对顺序  目前加上array.sort 可以在便利数组的时候进行排序
 */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        Arrays.sort(nums);
        int insertPos = 0; // 指向下一个非零元素应该插入的位置
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num; // 将非零元素移动到前面
            }
        }
        // 将剩余的位置填充为零
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }


    }

}
