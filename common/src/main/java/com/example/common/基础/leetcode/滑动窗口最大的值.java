package com.example.common.基础.leetcode;

/*
 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
返回 滑动窗口中的最大值 。
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 */
public class 滑动窗口最大的值 {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] nums1 = {1, -1};
        int k1 = 1;
        int[] result = maxSlidingWindow1(nums, k);
        for (int num : result) {
            System.out.print(num + " \n");
        }

        int[] result1 = maxSlidingWindow1(nums1, k1);
        for (int num : result1) {
            System.out.print(num + " ");
        }
    }

    /*  暴力解法  时间复杂度O(n*k)  空间复杂度O(1)
        超过了最大的时间限制  不推荐
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {//因为存在k的窗口长度  后面面就不需要再循环了
            int max = Integer.MIN_VALUE;
            //int[] temp = new int[k];
            for (int j = i; j < i + k; j++) {
                //temp[j - i] = nums[j];
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            result[i] = max;
        }
        return result;
    }

    //  TODO  使用双端队列优化  时间复杂度O(n)  空间复杂度O(k)
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        /*
        Deque 是双端队列接口，LinkedList 是其一种实现，保持元素的队首到队尾的顺序。
        这里队列里存的是元素的索引，不是值；算法通过在尾部弹出比当前值小的索引来维护“索引对应的值从队首到队尾单调递减”，因此队首始终是当前窗口的最大值。
        之所以用 Deque 类型是为了方便做 O(1) 的头尾增删（peekFirst/pollFirst/peekLast/pollLast），
        实现可以替换为 ArrayDeque 以获得更好性能（通常比 LinkedList 更快、内存更省）。
         */
        java.util.Deque<Integer> deque = new java.util.LinkedList<>();
        for (int i = 0; i < n; i++) {
            /* 作用：移除不在窗口范围内的元素
             队列里存的是元素的索引。当前窗口覆盖的索引范围是 [i - k + 1, i]（左边界为 i - k + 1）。
             因此当 deque.peekFirst() < i - k + 1时，说明队首索引在左边界左侧，已经不在当前窗口内，
             应该用pollFirst() 移除。举个数值例子：i=4, k=3，窗口是 2..4，索引 1（即 1 < 2`）就已经滑出窗口
             */
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();//移除队首的下标（队列里存的是元素的索引）
            }
            // 移除比当前元素小的元素，因为它们不可能成为最大值
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast(); //取队尾的下标 移出去
            }
            // 添加当前元素的索引
            deque.offerLast(i);
            // 当窗口形成时，记录当前窗口的最大值
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
