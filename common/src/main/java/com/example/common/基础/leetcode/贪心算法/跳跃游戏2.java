package com.example.common.基础.leetcode.贪心算法;

/*
 给定一个长度为 n 的 0 索引整数数组 nums。初始位置在下标 0。
每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在索引 i 处，你可以跳转到任意 (i + j) 处：
0 <= j <= nums[i] 且
i + j < n
返回到达 n - 1 的最小跳跃次数。测试用例保证可以到达 n - 1。
*/
public class 跳跃游戏2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        int[] nums1 = new int[]{1, 2, 1, 1, 1};
        int[] nums3 = new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        System.out.printf("\n" + jump(nums));
        System.out.printf("\n" + jump(nums1));
        System.out.printf("\n" + jump(nums3));

    }

    /*
      贪心 每一步的覆盖范围越大，需要的步数就越少
      这里最大的step 就会出现最小的跳跃次数 这是贪心算法的核心
      每一步的 “增量” 越大，总次数就越少
     */
    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return 0;
        int minSteps = 0;
        int maxSteps = 0;
        int end = 0;
        int n = nums.length;
        // 注意：i只需要遍历到n-2，因为到n-1已经是终点了，不需要再跳
        for (int i = 0; i < n - 1; i++) {
            // 更新能到达的最远位置
            maxSteps = Math.max(maxSteps, i + nums[i]);
            // 遍历到当前步数的边界，说明需要走下一步了
            if (i == end) {
                minSteps++;       // 步数+1
                end = maxSteps;   // 更新下一步的边界
            }
            // 提前终止：如果已经能到达终点，无需继续遍历
            if (end >= n - 1) {
                break;
            }
        }
        return minSteps;
    }
}
