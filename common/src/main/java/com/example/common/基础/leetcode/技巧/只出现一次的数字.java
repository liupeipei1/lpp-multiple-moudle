package com.example.common.基础.leetcode.技巧;

import java.util.HashMap;

/*
 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
输入：nums = [2,2,1]
输出：1

输入：nums = [4,1,2,1,2]

输出：4
 */
public class 只出现一次的数字 {

    public static void main(String[] args) {
        只出现一次的数字 solution = new 只出现一次的数字();
        int[] nums = {4, 1, 2, 1, 2};
        int result = solution.singleNumber(nums);
        System.out.println(result); // 输出: 4

    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.entrySet().stream().filter(p -> p.getValue() == 1).findFirst().get().getKey();
    }

    /*
     最优解  位运算 异或运算 满足交换律和结合律 任何数和0异或为任何数 任何数和其自身异或为0
     x ^ x = 0（偶数次抵消为 0）；
     0 ^ x = x（0 异或任何数等于自身）；
     推导 “x 出现 3 次” 的结果：
   x ^ x ^ x = (x ^ x) ^ x = 0 ^ x = x 偶数次的异或结果为 0，奇数次就是 “偶数次抵消后 + 1 次 x”，最终结果还是 x
  2^3 异或是二进制的计算 不是十进制： 异或（^）是二进制位运算，规则是「相同为 0，不同为 1」，这三个特性是代码能生效的核心：
  2 → 1 0
  3 → 1 1
异或→ 0 1  （第一位：1和1相同→0；第二位：0和1不同→1）
因为这个数组只会出现一个数出现一次，其他数都出现两次，所以我们可以利用异或运算的特性来解决这个问题。对于数组中的每个元素，我们将它们进行异或运算，最终得到的结果就是那个只出现一次的元素。
    例如，输入数组 [4, 1, 2, 1, 2]，我们可以进行如下计算：
4 ^ 1 ^ 2 ^ 1 ^ 2
 偶数的都是会被抵消，只有出现的单个的数会被保留下来 这样等于子本身 不适用数组存在出现多个奇数次的数的情况
     */
    public  int singleNumber2(int[] nums) {
        int res = 0;
        for(int x : nums){
            res ^= x;
        }
        return res;

    }
}
