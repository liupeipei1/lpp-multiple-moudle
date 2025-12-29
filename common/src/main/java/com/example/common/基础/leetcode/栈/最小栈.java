package com.example.common.基础.leetcode.栈;

import java.util.Arrays;

/*
 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
实现 MinStack 类:
MinStack() 初始化堆栈对象。
void push(int val) 将元素val推入堆栈。
void pop() 删除堆栈顶部的元素。
int top() 获取堆栈顶部的元素。
int getMin() 获取堆栈中的最小元素。
 */
public class 最小栈 {
    private int[] mainArray; // 主数组
    private int[] minArray;  // 最小值数组
    private int size;        // 当前栈的元素个数
    private static final int DEFAULT_CAPACITY = 10; // 默认初始容量

    public 最小栈() {
        mainArray = new int[DEFAULT_CAPACITY];
        minArray = new int[DEFAULT_CAPACITY];
        size = 0;
    }
    // 扩容逻辑：数组满了则扩容为原来的2倍
    private void resize() {
        if (size == mainArray.length) {
            mainArray = Arrays.copyOf(mainArray, mainArray.length * 2);// 原数组   新长度
            minArray = Arrays.copyOf(minArray, minArray.length * 2);
        }
    }
    public void push(int val) {
        resize(); // 先判断是否需要扩容
        mainArray[size] = val;
        // 同步更新最小值数组
        if (size == 0) {
            minArray[size] = val;
        } else {
            minArray[size] = Math.min(val, minArray[size - 1]);
        }
        size++;
    }

    //delete 最上面的数据
    public void pop() {
        if (size > 0) {
            size--; // 仅需移动指针，无需置0
        }
    }

    public int top() {
        if (size == 0) {
            throw new RuntimeException("栈为空，无法获取栈顶元素");
        }
        return mainArray[size - 1]; // 栈顶是size-1位置，不修改size
    }

    public int getMin() {
        if (size == 0) {
            throw new RuntimeException("栈为空，无法获取最小值");
        }
        return minArray[size - 1]; // 直接取最小值数组的栈顶（O(1)）
    }
}
