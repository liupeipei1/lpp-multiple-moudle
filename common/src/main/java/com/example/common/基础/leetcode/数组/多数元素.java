package com.example.common.基础.leetcode.数组;
/*
    给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 n/2 的元素。
    你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    输入：[2,2,1,1,1,2,2]
    输出：2
 */
public class 多数元素 {
    public static void main(String[] args) {
        多数元素 solution = new 多数元素();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int result = solution.majorityElement(nums);
        System.out.println(result); // 输出: 2
    }

    /*
    摩尔投票算法：该算法的核心思想是通过抵消的方式找到数组中的多数元素。
    首先，我们初始化一个候选元素 candidate 和一个计数器 count。我们遍历数组中的每个元素 num：
    如果 count 为 0，我们将 candidate 设置为当前元素 num，并将 count 设置为 1。
    如果 num 等于 candidate，我们将 count 增加 1。
    否则，我们将 count 减少 1。
    最后，candidate 就是数组中的多数元素。
    */
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }
}
