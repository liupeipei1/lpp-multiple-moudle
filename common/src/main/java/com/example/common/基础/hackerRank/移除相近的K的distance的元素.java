package com.example.common.基础.hackerRank;

import java.util.ArrayList;
import java.util.List;

/*
 Given a non-decreasing array of integers and an integer K,
 remove in-place any element that is within K of the previous kept element
 and return the new length. Use constant extra space and single pass with two pointers.
 移除当前元素与上一个元素 在K的范围内，然后最后得到一个新的数组 用双指针的方式
timestamps = [1, 2, 3, 8, 10]
K = 3

比如 1和2  2-1< 3 remove 2
3-1  remove 3
8-1> 3 keep
10-8< 3  remove 10
 */
public class 移除相近的K的distance的元素 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(8);
        list.add(10);
        System.out.printf("" + debounceTimestamps(list, 3));
    }


    public static int debounceTimestamps(List<Integer> timestamps, int k) {
        if (timestamps == null || timestamps.size() == 0) {
            return 0;
        }
        int slow = 0; // 慢指针：上一个保留元素的下标
        int keep = timestamps.get(0);
        for (int fast = 1; fast < timestamps.size(); fast++) {
            int current = timestamps.get(fast);
            if (current - keep >= k) {
                keep = current;
                slow++;
                // 原地覆盖（把当前元素放到慢指针位置）
                timestamps.set(slow, current);
            }
        }
        return slow + 1;
    }


    public static int debounceTimestamps1(List<Integer> timestamps, int K) {
        // Write your code here
        int n = timestamps.size();
        if(n<=1) return n;
        int left = 0;
        int right = 1; //将比较的按照 右边先移动一位  快慢查找
        int count = 1; //因为第一个数是keep的
        while(right < n){
            if(timestamps.get(right) - timestamps.get(left) < K){ //当右边的值-左边的值 在k的范围 那么右边下标需要移动 因为换成下一个右边的值
                right++;
            } else {
                count++;
                left = right; //当值大于k 那么 左边的下标需要换成右边的
                right = right + 1; //然后将右边的值往右边再一定一位
            }
        }
        return count;
    }
}
