package com.example.common.基础.leetcode.数组;

/*
    给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     输入: nums = [1,2,3,4,5,6,7], k = 3
     输出: [5,6,7,1,2,3,4]
 */
public class 轮转数组 {
    public static void main(String[] args) {
        轮转数组 solution = new 轮转数组();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(nums, k);
        // 输出: [5,6,7,1,2,3,4]
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.printf("\n");
        int[] nums1 = {1, 2};
        solution.rotate(nums1, 7);
        for (int num : nums1) {
            System.out.print(num + " ");
        }

    }

    /*
     轮转数组的解法有多种，以下是其中两种常见的方法：
     1. 暴力解法：将数组中的元素逐个移动 k 次，时间复杂度为 O(n*k)，空间复杂度为 O(1)。
     2. 反转数组：先将整个数组反转，然后分别反转前 k 个元素和后 n-k 个元素，时间复杂度为 O(n)，空间复杂度为 O(1)。
      反转数组的步骤如下：
      1. 反转整个数组。
         2. 反转前 k 个元素。
         3. 反转后 n-k 个元素。
      例如，对于输入 nums = [1,2,3,4,5,6,7] 和 k = 3：
      1. 反转整个数组得到 [7,6,5,4,3,2,1]。
      2. 反转前 k 个元素得到 [5,6,7,4,3,2,1]。
      3. 反转后 n-k 个元素得到 [5,6,7,1,2,3,4]。
      最终得到的结果就是 [5,6,7,1,2,3,4]。
      这种方法的时间复杂度为 O(n)，因为我们需要遍历数组三次进行反转操作，空间复杂度为 O(1)，因为我们只使用了常数级别的额外空间来存储临时变量。
      这种方法的优点是效率较高，适用于大规模的数组，而暴力解法在 k 较大时效率较低，不适合处理大规模的数组。
      当然，还有其他的解法，例如使用额外的数组来存储轮转后的结果，或者使用环状替换的方法来实现轮转，但反转数组的方法是比较常见且高效的解法之一。
         下面是使用反转数组方法实现轮转数组的代码示例：
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] in = new int[n];
        System.arraycopy(nums, 0, in, 0, n);
        for (int i = 0; i < n; i++) {
            int index = (i + k) % n; //计算轮转后元素的新位置
            nums[index] = in[i];
        }
    }
}
