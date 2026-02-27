package com.example.common.基础.leetcode.数组;

import java.util.Arrays;

/*
 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1
的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class 合并两个有序数组 {

    public static void main(String[] args) {
        合并两个有序数组 solution = new 合并两个有序数组();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        solution.merge1(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }

    //nums1 是一个长度为 m + n 的数组，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //将两个数组合并到 nums1 中
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }


    //
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1; //nums1的指针
        int p2 = n - 1; //nums2的指针
        int p = m + n - 1; //合并后数组的指针

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) { // 把更大的数放到 nums1[p] 位置
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        // 如果 nums2 还有剩余元素，直接填充到 nums1 前面的位置
        // System.arraycopy(源数组, 源起始索引, 目标数组, 目标起始索引, 复制长度)
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
