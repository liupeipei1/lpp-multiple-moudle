package com.example.common.基础.leetcode.栈;

public class TestMiniStack {

    public static void main(String[] args) {
        最小栈 min = new 最小栈();

        min.push(-2);
        min.push(1);
        min.push(-3);
        System.out.printf("\n" + min.getMin());
        min.pop();
        System.out.printf("\n" + min.top());
        System.out.printf("\n" + min.getMin());
    }
}
