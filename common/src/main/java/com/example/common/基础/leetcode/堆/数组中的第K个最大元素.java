package com.example.common.基础.leetcode.堆;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
输入: [3,2,1,5,6,4], k = 2
输出: 5
 */
public class 数组中的第K个最大元素 {

    public static void main(String[] args) {
        System.out.printf("" + findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));

    }

    public static int findKthLargest(int[] nums, int k) {
        // 边界校验（同上）
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }
        if (k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("k必须是1到数组长度之间的整数");
        }
        // 核心：创建容量为k的最小堆（默认就是最小堆，无需自定义Comparator）
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (minHeap.size() < k) {
                // 堆未满，直接插入
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                // 堆已满，当前元素 > 堆顶（堆中最小的），则替换堆顶
                minHeap.poll();
                minHeap.offer(num);
            }
            // 否则：当前元素 <= 堆顶，无需处理（不可能是前k大）
        }
        // 堆顶就是第K大的元素（堆中存储的是前k大的元素，最小的那个就是第K大）
        return minHeap.peek();
    }


}
