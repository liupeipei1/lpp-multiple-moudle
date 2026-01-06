package com.example.common.基础.leetcode.堆;

import java.util.PriorityQueue;

/*
  大小堆的方式
  将一串数组分成两部分 左边 存储小的数据  用降序的方式 就是大堆顶的的方式
  右边存储大的数据 用升序的方式，也就是栈顶是最小的，一定保证左边的栈顶是小于右边的栈顶的数据
  左边的size大于右边的size
 */
public class MedianFinder {
    PriorityQueue<Integer> leftQueue; //大顶堆
    PriorityQueue<Integer> rightQueue;//小顶堆

    public MedianFinder() {
        leftQueue = new PriorityQueue<>((a, b) -> b - a);
        rightQueue = new PriorityQueue<>();//小顶堆
    }

    public void addNum(int num) {
        leftQueue.add(num);
      //  1. 左堆顶 > 右堆顶 → 把左堆顶移到右堆（保证左小右大）
        if (!rightQueue.isEmpty() && leftQueue.peek() > rightQueue.peek()) { //左边的顶不能大于右边的顶 也就是左边最大值不能超过右边最小值
            rightQueue.add(leftQueue.poll());
        }
        // 2. 左堆大小 - 右堆大小 > 1 → 把左堆顶移到右堆（保证大小差≤1）
        if (leftQueue.size() - rightQueue.size() > 1) { //左边的比右边顶多大一
            rightQueue.add(leftQueue.poll());
        }
        // 3. 右堆大小 - 左堆大小 > 0 → 把右堆顶移到左堆（保证左堆略大）
        if (rightQueue.size() - leftQueue.size() > 0) {//右边的不能比左边的size大
            leftQueue.add(rightQueue.poll());
        }
    }

    public double findMedian() {
        if(leftQueue.isEmpty() && rightQueue.isEmpty()){
            return 0;
        }
        if (leftQueue.size() > rightQueue.size()) {
            return leftQueue.peek();
        }
        //偶数的情况
        return (leftQueue.peek() + rightQueue.peek())/2.0;
    }
}
