package com.example.common.基础.leetcode.堆;

import java.util.Arrays;

//超出时间限制了
@Deprecated
public class MedianFinder_timeout {
    int[] arr;
    int size = 0;
    final int capability = 10;

    public MedianFinder_timeout() {
        arr = new int[capability];
    }

    public void resize() {
        if (size == capability || size == arr.length) {
            arr = Arrays.copyOf(arr, size * 2);
        }
    }
   // 但每次添加元素都全量拷贝 + 排序 时间复杂度是 O(n log n)
    public void addNum(int num) {
        resize();
        arr[size++] = num;
        int[] sorted = Arrays.copyOf(arr, size);
        Arrays.sort(sorted);
        arr=sorted;
    }

    public double findMedian() {
        if (size == 0) {
            return 0.0;
        }
        double midIndex = size / 2.0;
        if ((size) % 2 == 0) { //偶数
            return (arr[(int) (midIndex - 1)] + arr[(int) midIndex]) / 2.0;
        } else {//奇数
            return arr[(int) midIndex];
        }
    }
}
