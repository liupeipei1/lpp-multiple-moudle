package com.example.common.基础.leetcode;

import java.util.Arrays;
// 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
public class 缺失的第一个整数 {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums));

        System.out.println(firstMissingPositive2(nums));
    }

    /*
     要点：
        第一段循环通过交换把值 x 放到索引 x-1 上（前提是 1 ≤ x ≤ n），即把每个可能的位置放对。条件 nums[nums[i]-1] != nums[i] 防止重复值导致无限循环。
        第二段循环从头到尾检查第一个不满足 nums[i] == i+1 的位置，返回 i+1，即缺失的最小正整数。
        如果所有位置都对，则返回 n+1（比如数组包含 1..n 的情况）。
        时间复杂度 O(n)，空间复杂度 O(1)。
        方法二：置换
     */
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // 交换 nums[i] 和 nums[nums[i] - 1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    /*
     步骤 1（第一个循环）：
    把数组中所有非正数（≤0）设为 n+1。
    目的：排除掉无关值（负数、0、大于 n 的数），避免后续下标越界或错误标记。
    步骤 2（第二个循环）：
    取当前值的绝对值 num = Math.abs(nums[i])；若 1 <= num <= n，则令 nums[num-1] = -Math.abs(nums[num-1])。
    目的：将表示数字 num 的位置标为负，表示数字 num 在数组中出现过。使用 Math.abs 保证已标记的位不会被反向改正。
    步骤 3（第三个循环）：
    从头扫描第一个仍为正数的位置 i，返回 i+1，即缺失的最小正整数。
    若所有位置都为负，说明 1..n 都出现过，返回 n+1。
    复杂度与注意事项：
    时间复杂度：O(n)。空间复杂度：O(1)（原地修改数组）。
    会修改输入数组；若需要保留原数组需先拷贝。
   */
    public int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    /*
     这是「排序法」（sort + 扫描）来找缺失的最小正整数。 可以理解的solution
     */
    public static int firstMissingPositive2(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);//排序
        int minimum = 1;
        for (int i = 0; i < length; ++i) {
            if (nums[i] <= 0 || nums[i] < minimum) {
                continue;
            }
            if(nums[i] == minimum) {
                minimum++;
            } else if (nums[i] > minimum) {
                return minimum;
            }

        }
        return minimum;
    }
}
