package com.example.common.基础.leetcode.技巧;

/*
 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */
public class 颜色分类 {
    public static void main(String[] args) {
        颜色分类 solution = new 颜色分类();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ===");
        }
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        solution.sortColors1(nums1);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }

    /*
        冒泡
        嵌套循环通过两层遍历 + 相邻元素比较交换，把数组中较小的元素逐步 “挪” 到前面，较大的元素 “挪” 到后面，最终让数组从小到大有序。
     */
    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int next = nums[j];
                    int cur = nums[i];
                    nums[i] = next;
                    nums[j] = cur;
                }
            }
        }
    }

    //荷兰国旗算法  三指针  因为按照 0  1 2颜色分类
       /*
        1. 初始化三个指针：left 指向数组的开头，right 指向数组的末尾，cur 指向当前元素。
        2. 遍历数组：
            - 如果 nums[cur] == 0，交换 nums[cur] 和 nums[left] 的值，并将 left 和 cur 都向右移动一位。
            - 如果 nums[cur] == 1，cur 向右移动一位。
            - 如果 nums[cur] == 2，交换 nums[cur] 和 nums[right] 的值，并将 right 向左移动一位（注意 cur 不移动，因为交换后的元素需要再次检查）。
        3. 重复上述步骤直到 cur 超过 right。
     */
    public void sortColors1(int[] nums) {
        int left = 0;  //0的区域
        int cur = 0;
        int right = nums.length - 1;

        while (cur <= right) {
            if (nums[cur] == 0) {
                swap(nums, cur, left);//交换当前元素和left指针指向的元素
                left++;
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, right);
                right--;
            } else {
                cur++;
            }
        }

    }

    //两两元素交换
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
