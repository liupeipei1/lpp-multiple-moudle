package com.example.common.基础.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
  给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
   满足 i != j、i != k 且 j != k ，
  同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 */
public class 三数之和15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums1 = {3, -1, -1, 0, 1, 1};
        System.out.println(threeSum(nums));
        System.out.println(threeSum(nums1));
        System.out.println(threeSum2(nums1));
    }

    /*
       1.三个数必须不重复  并且和为0
       原因很简单：当 sum == 0 时，你只把三元组加入 rsult，
       却没有移动 left 或 right 指针（也没跳过重复值），
       所以 left/right 不变，while (left < right) 永远成立，
       进入死循环。另一个问题是外层循环应是 i < nums.length - 2 并跳过重复首元素。
       best practice

     */

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rsult = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return rsult;
        }
        Arrays.sort(nums);// in order
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {  //便利的当前元素如果已经便利 过了 那么就不要再遍历，因为 第一次遍历的时候  左移右移已经都处理过了
                continue;// remove the
            }
            int left = i + 1;
            int right = nums.length - 1; //控制 当前元素的左边 + 右边根据是否符合规定进行左右偏移
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    rsult.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; // skip duplicate
                    while (left < right && nums[right] == nums[right - 1]) right--; // skip duplicate
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return rsult;
    }

    /*
      retrun list  超出时间限制
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> rsult = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return rsult;
        }
        //暴力破解
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = new java.util.ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        Collections.sort(triplet);
                        rsult.add(triplet);
                    }
                }
            }
        }
        return rsult.stream().distinct().collect(Collectors.toList());
    }

    //优化方法 双指针  best solution   {3，-1, -1, 0, 1, 1};
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums); // 先排序
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 跳过重复元素 第一个元素和第二个元素不能相等
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; // 跳过重复元素  第二个和第三个不能相同
                    while (left < right && nums[right] == nums[right - 1]) right--; // 跳过重复元素
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
