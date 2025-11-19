package com.example.common.基础.leetcode;

import java.util.Arrays;

/*
最长连续序列
输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class 最长连续序列128 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    /*
     就是用哈希表查找这个数前面一个数是否存在，即num-1在序列中是否存在。存在那这个数肯定不是开头，直接跳过。
    因此只需要对每个开头的数进行循环，直到这个序列不再连续，因此复杂度是O(n)。
     */
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        java.util.Set<Integer> set = new java.util.HashSet<>();
        for (int n : nums) set.add(n);
        int longest = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {//是否是第一个数 不是第一个数字 立马跳过
                int current = 1;
                int val = n;
                while (set.contains(val + 1)) {
                    current++;
                    val++;
                }
                if (current > longest) longest = current;
            }
        }
        return longest;
    }
}
