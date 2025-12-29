package com.example.common.基础.leetcode.栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。
输入：s = "([)]"
输出：false
 */
public class 有效的括号 {

    public static void main(String[] args) {
        System.out.printf("\n" + isValid("([]{)}"));
        System.out.printf("\n" + isValid("()"));
        System.out.printf("\n" + isValid1("([]{)}"));
        System.out.printf("\n" + isValid1("()"));

    }

    /*
     先进后出  栈的特性是想碟子一样，后面放的 先走
     将所有的左边的括号都放在栈里面，然后循环到右边的时候，然后判断是否和栈顶 的 符号是否匹配即可
     如果栈顶的符号和循环当前的括号不是一对 那么就是false 或者当栈是空的也说明是不匹配的 因为存在右边括号开头的情况
     */
    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) return false;
        Deque<Character> stack = new ArrayDeque<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        //将左边的括号放进栈里面  这样后面进去的括号 会先出来，这样只要能匹配上就是有效的括号
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != map.get(ch)) { //peek查看元素  pop是出栈
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }


    //solution 2 不用栈  这里注意--i 和 i++ 否则会存在取的是下一个值的问题
    public static boolean isValid1(String s) {
        if (s.length() % 2 != 0) return false;
        char[] bracket = new char[s.length()];
        char[] chars = s.toCharArray();
        int i = 0;
        char left;
        for (char c : chars) {
            switch (c) {
                case ')':
                    if (i == 0) {
                        return false;
                    }
                    left = bracket[--i]; //最上面的左边括号  这里必须死--i 不能是i-- 不然会出现i=1 当--i 应该是取i=0的值，但是如果i-- 就会取的是i=1的值 然后再i--
                    if (left != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (i == 0) {
                        return false;
                    }

                    left = bracket[--i];
                    if (left != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (i == 0) {
                        return false;
                    }
                    left = bracket[--i];
                    if (left != '{') {
                        return false;
                    }
                    break;
                default:
                    bracket[i++] = c; //这里千万要记住是i++  当i=0 时这里先给0的地方赋值 不然++i会出现先给1的地方赋值 导致结果有问题
            }
        }
        return i == 0;
    }
}
