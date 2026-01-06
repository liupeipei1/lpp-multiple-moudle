package com.example.common.基础.leetcode.栈;

import java.util.ArrayDeque;
import java.util.Deque;
/*
 按照上面的思路，我们只需要设计一个数据结构，使得每个元素 a 与其相应的最小值 m 时刻保持一一对应。
 因此我们可以使用一个辅助栈，与元素栈同步插入与删除，用于存储与每个元素对应的最小值。
当一个元素要入栈时，我们取当前辅助栈的栈顶存储的最小值，与当前元素比较得出最小值，将这个最小值插入辅助栈中；
当一个元素要出栈时，我们把辅助栈的栈顶元素也一并弹出；
在任意一个时刻，栈内元素的最小值就存储在辅助栈的栈顶元素中
 */
public class MiniStack辅助栈解决 {
    Deque<Integer> mainStack;
    Deque<Integer> miniStack;

    public MiniStack辅助栈解决() {
        mainStack = new ArrayDeque<>();
        miniStack = new ArrayDeque<>();
        miniStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        mainStack.push(val);
        miniStack.push(Math.min(miniStack.peek(), val));
    }

    public void pop() {
        mainStack.pop();
        miniStack.pop();
    }


    public int top() {
        return mainStack.peek();
    }


    public int getMin() {
        return miniStack.peek();
    }
}
