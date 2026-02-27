package com.example.common.基础.leetcode.技巧;

import java.util.HashMap;
import java.util.Map;

/*
 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 输入：nums = [3,2,3]
 输出：3
 */
public class 多数元素 {

    public static void main(String[] args) {
        多数元素 solution = new 多数元素();
        int[] nums = {3, 2, 3};
        int result = solution.majorityElement(nums);
        System.out.println(result); // 输出: 3
        int[] nums1 = {2,2,1,1,1,2,2};
        System.out.println(solution.majorityElement(nums1)); // 输出2
    }

    /*
     暴力破解
     */
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

    /*
        最优解  摩尔投票算法
            1. 初始化一个计数器 count 和一个候选元素 candidate。
            2. 遍历数组中的每个元素 num：
                - 如果 count 为 0，将 candidate 设置为当前元素 num，并将 count 设置为 1。
                - 否则，如果 num 等于 candidate，增加 count；如果 num 不等于 candidate，减少 count。
            3. 最后，candidate 就是多数元素。
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count += (nums[i] == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
