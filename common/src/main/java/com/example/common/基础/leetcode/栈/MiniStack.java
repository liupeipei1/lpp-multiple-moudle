package com.example.common.基础.leetcode.栈;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 找到最小的栈  这里是直接用的栈的方法 并且通过stream 的Integer的 compare方法获取的最小值
 */
public class MiniStack {

    Deque<Integer> stack = new ArrayDeque<>();

    public MiniStack() {
    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stack.stream().min(Integer::compare).get();
    }
}
