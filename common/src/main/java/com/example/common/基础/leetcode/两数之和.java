package com.example.common.基础.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");

        int[] result2 = twoSum2(nums, target);
        System.out.println("Indices: [" + result2[0] + ", " + result2[1] + "]");
    }

    public  static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }

            }

        }
        return null;
    }

    /*优化方法
     1.使用哈希表存储已经遍历过的元素及其索引
     2.在遍历数组时，计算当前元素所需的补数（target - nums[i]）
     3.检查补数是否存在于哈希表中，如果存在则返回对应的索引
     4.如果不存在，则将当前元素及其索引存入哈希表中*/
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
