package com.example.common.基础.leetcode.数组;

/*
 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
输入：nums = [1,1,1,2,2,3]
输出：5, nums = [1,1,2,2,3]
解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 */
public class 删除有序数组中的重复项2 {

    public static void main(String[] args) {
        删除有序数组中的重复项2 solution = new 删除有序数组中的重复项2();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int result = solution.removeDuplicates(nums);
        System.out.println(result); // 输出: 5
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        System.out.println(solution.removeDuplicates2(nums1)); // 输出: 5
    }

    /*  数组是有序的  所以重复的元素一定是相邻的  因此我们可以使用快慢指针来解决这个问题
        快慢指针的思路是：慢指针 slow 指向当前处理的元素，快指针 fast 用于遍历数组。当 fast 指向的元素不等于 slow 前两个元素时，
        说明当前元素出现次数没有超过两次，可以保留。
        此时将 slow 向前移动一位，并将 fast 指向的元素赋值给 slow。最后返回 slow 的位置即为新数组的长度。

     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 2) return 2; //如果数组长度为2 直接返回2 因为题目要求出现次数超过两次的元素只出现两次
        int slow = 2; //前两个一定保留 从第三个元素开始判断
        for (int fast = 2; fast < nums.length; fast++) {
            //如果当前元素不等于慢指针前两个元素 说明当前元素出现次数没有超过两次 可以保留
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public int removeDuplicates2(int[] nums) {
        int slow = 2;  //无论前面元素怎么样前两个数字保持不变
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow-2]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow;
    }
}
