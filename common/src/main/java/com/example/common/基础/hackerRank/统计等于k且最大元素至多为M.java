package com.example.common.基础.hackerRank;

import java.util.*;

/*
Given an integer array nums and integers k and M,
count the number of contiguous subarrays whose sum equals k and whose maximum element is at most M.
We need subarrays with sum = 3 and all elements ≤ 2.
Also, any subarray containing 3 is invalid because 3 > M. Check all starts:

sum要求是K  元素最大的值不超过M  而且是必须的是连续的
- From index 0: [2, -1, 2] → sum = 3, max = 2 → valid (count = 1).
- From index 2: [2, 1] → sum = 3, max = 2 → valid (count = 2). No other subarray qualifies. Thus the total count is 2.
 */
public class 统计等于k且最大元素至多为M {
    public static void main(String[] args) {
        //case1
        /*
         nums = [2, -1, 2, 1, -2, 3]
            k = 3
            M = 2
         */
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(-1);
        list.add(2);
        list.add(1);
        list.add(-2);
        System.out.printf("count:" + countSubarraysWithSumAndMaxAtMost(list, 3, 2));

    }

    /*
      思路： 两个循环  注意这里必须是连续的
       第一个全量循环  下一个循环按照第一个循环往下走
       当元素值超过M  或者 和超过K那么说明第一个循环的元素是不符合条件 继续下一个循环
     */
    public static long countSubarraysWithSumAndMaxAtMost(List<Integer> nums, long k, long M) {
        // Write your code here
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            int currentSum = 0;
            for (int j = i; j < nums.size(); j++) {
                currentSum += nums.get(j);
                // 提前终止：当前值大于k
                if (nums.get(j) > M) {//因为要求子元素是连续的 所以只要其中一个大于则跳出该case
                    break;
                }
                if (currentSum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
