package com.example.common.基础.leetcode.数组;

/*
 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
返回 k。
输入：nums = [3,2,2,3], val = 3
输出：2, nums = [2,2,_,_]
 */
public class 移除元素 {

    public static void main(String[] args) {
        移除元素 solution = new 移除元素();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int result = solution.removeElement(nums, val);
        System.out.println(result); // 输出: 2

        int result1 = solution.removeElement2(nums, val);
        System.out.println(result1); // 输出: 2

    }


    /*
     暴力解法：创建一个新的数组 rs 来存储不等于 val 的元素。遍历原数组 nums，如果当前元素不等于 val，就将其添加到 rs 中，并增加计数器 k。最后将 rs 中的前 k 个元素复制回 nums，并返回 k。
     */
    public int removeElement(int[] nums, int val) {
        int k = 0;//记录不等于val的元素数量
        int len = nums.length;
        int[] rs = new int[len];
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                k++;
                rs[k++] = nums[i];
            }
        }
        System.arraycopy(rs, 0, nums, 0, len);
        return k;
    }


    //快慢针的方法
    public int removeElement2(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
