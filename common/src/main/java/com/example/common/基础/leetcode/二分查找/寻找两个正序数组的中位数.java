package com.example.common.基础.leetcode.二分查找;

import java.util.Arrays;
import java.util.List;

/*
中位数
 数据长度为奇数：中位数 = 排序后数组中间位置的数（索引为 n/2，n 为数组长度，向下取整）；
    例：[1,3,5] → 中位数是 3（索引 1）；
    数据长度为偶数：中位数 = 排序后数组中间两个数的平均值；
    例：[1,2,3,4] → 中位数是 (2+3)/2 = 2.5。
 */
public class 寻找两个正序数组的中位数 {

    public static void main(String[] args) {
        double r = findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.printf("" + r);

        double r1 = findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4});
        System.out.printf("" + r1);
    }

    //首先合并数组  找到中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2 == null && nums1 == null) return 0;
        int m = nums1.length;
        int n = nums2.length;
        int ll = m + n;
        int[] all = new int[ll];

        for (int i = 0; i < m; i++) {
            all[i] = nums1[i];
        }

        for (int i = 0; i < n; i++) {
            all[i + m] = nums2[i];
        }

        Arrays.sort(all);
        double ans = 0;
        if ((ll) % 2 == 0) { //偶数
            ans = (all[ll / 2 - 1] + all[ll / 2]) / 2.0;  //中间数 +中间前面的数算平均数
        } else {
            ans = all[ll / 2];
        }
        return ans;
    }

}
