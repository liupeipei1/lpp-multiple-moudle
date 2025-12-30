package com.example.common.基础.leetcode.栈;

import java.util.*;

/*
 给定一个经过编码的字符串，返回它解码后的字符串。
编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
测试用例保证输出的长度不会超过 105。
 */
public class 字符串解码 {
    public static void main(String[] args) {
        System.out.printf("\n" + decodeString("asd3[ad2[cd]]"));
        System.out.printf("\n" + decodeString1("3[ad2[cd]]"));
    }

    /*  解码字符串
       1. 存数字 当碰到[ 那就是开始存进去数字栈，
          需要注意的是数字可能是多位数，所以需要处理多位数的情况
          例如 100[a] 这里就需要将100存入栈中
          将字符串
       2. 存字符串 当碰到] 那就是出栈操作 取出前缀字符串和重复次数
     */
    public static String decodeString(String s) {
        if (s == null) return s;
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        StringBuilder curr = new StringBuilder();
        int currNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //判断是数字 需要 存储 栈里面
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0'); //处理多位数
            } else if (c == '[') {
                numStack.push(currNum); //当遇到左括号时，将当前数字压栈
                //左括号开始就是当前字符串开始的
                strStack.push(curr.toString());
                curr.setLength(0); //清空当前字符串
                currNum = 0; //重置当前数字
            } else if (c == ']') { //出栈操作
                int repeat = numStack.pop();
                String prefix = strStack.pop(); //弹出前缀字符串
                StringBuilder temp = new StringBuilder(prefix);
                //将当前子串重复repeat次，拼接到前缀后
                temp.append(multipleStr(curr.toString(), repeat));
                curr = temp;
            } else {//既不是括号也不是数字 纯字母
                curr.append(c); //直接拼接当前字符
            }
        }
        return curr.toString();
    }

    public static String multipleStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static String decodeString1(String s) {
        if (s == null || s.isEmpty()) return s;

        // 数字栈：存储括号前的重复次数
        Deque<Integer> numStack = new ArrayDeque<>();
        // 字符串栈：存储括号外的前缀字符串
        Deque<String> strStack = new ArrayDeque<>();
        // 临时存储当前拼接的字符串（括号内的子串/普通字符）
        StringBuilder currStr = new StringBuilder();
        // 临时存储当前解析的数字（处理多位数）
        int currNum = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 步骤1：解析数字（处理多位数，如100[a]）
                currNum = currNum * 10 + (c - '0');
            } else if (c == '[') {
                // 步骤2：遇到左括号，将当前数字和字符串压栈，重置临时变量
                numStack.push(currNum);
                strStack.push(currStr.toString());
                currNum = 0;
                currStr.setLength(0); // 清空当前字符串
            } else if (c == ']') {
                // 步骤3：遇到右括号，拼接重复后的字符串
                int repeat = numStack.pop(); // 弹出重复次数
                String prefix = strStack.pop(); // 弹出前缀字符串
                // 将当前子串重复repeat次，拼接到前缀后
                StringBuilder temp = new StringBuilder(prefix);
                temp.append(currStr.toString().repeat(repeat));
                // 更新当前字符串为拼接后的结果
                currStr = temp;
            } else {
                // 步骤4：普通字符，直接拼接
                currStr.append(c);
            }
        }

        return currStr.toString();
    }
}
