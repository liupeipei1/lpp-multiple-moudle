package com.example.common.基础.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

/*
 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class 括号生成 {
    public static void main(String[] args) {
        generateParenthesis(2);
        for (String r : rs) {
            System.out.printf("\n" + r);
        }
    }

    static List<String> rs = new ArrayList();

    //注意 这里的n是n对括号 也就是昨天也是n 右边也是n
    public static List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return rs;
        }
        getGenerateParentheses("", n, n);
        return rs;
    }
    /*
    剩余左括号总数要小于等于右括号，实际上已经组成的括号一定「任意前缀左≥右」这样才能符合配对
     以 left=2, right=2 为例
     初始调用：getGenerateParentheses("", 2, 2)
    left == right → 加左括号 → 调用 ("{", 1, 2)。
    第一层递归：("{", 1, 2)
    left < right（1<2）：
    left > 0 → 加左括号 → 调用 ("{{", 0, 2)；
    加右括号 → 调用 ("{ }", 1, 1)（为方便看，空格分隔）。
 子分支 1：("{{", 0, 2)
    left < right（0<2）：
    left=0 → 不能加左括号；
    加右括号 → 调用 ("{{}", 0, 1)；
    继续递归：("{{}", 0, 1) → 加右括号 → 调用 ("{{}}", 0, 0)；
    触发终止条件 → rs.add("{{}}")。
 子分支 2：("{ }", 1, 1) //当let< right  & left>0 已经递归结束后 left会回到当初的1，right 2-1,也就是是分之二的可能性
    left == right → 加左括号 → 调用 ("{ }{ ", 0, 1)（即 "{}{"）；
    递归：("{}{", 0, 1) → 加右括号 → 调用 ("{}{}", 0, 0)；
    触发终止条件 → rs.add("{}{}")。
     */
    public static void getGenerateParentheses(String string, int left, int right) {
        if (left == 0 && right == 0) {//数量相等：最终左括号 { 和右括号 } 的数量必须相等（对应递归终止条件 left == 0 && right == 0）；
            rs.add(string);
            return;
        }
        //当left == right 下一个只能用左边的括号 这种重点
        if (left == right) {
            getGenerateParentheses(string + "(", left - 1, right); //字符串不可变，天然回溯，无需手动删字符
        } else if (left < right) { //当left小于right 可以用左边的也可以右边的
            if (left > 0) {// 左括号还有剩余，可加左括号
                getGenerateParentheses(string + "(", left - 1, right);
            }
            getGenerateParentheses(string + ")", left, right - 1); // 必加右括号（因为left < right，加右括号后仍满足左≥右）
        }
    }
}
