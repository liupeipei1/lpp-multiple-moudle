package com.example.common.基础.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 从前 到后 和从过后到前是一样的 并且能对称 那么就是回文
 */
public class 回文链表 {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.printf("rs:" + solution(l1));

        ListNode l2 = new ListNode(0, new ListNode(0));
        System.out.printf("rs:" + solution(l2));

        ListNode l3 = new ListNode(1);
        System.out.printf("rs:" + solution(l3));
    }


    public static boolean solution(ListNode head) {
        //循环该单链表
        ListNode temp = head;
        List<Integer> list = new ArrayList<>(); //这里必须用list
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int front = 0;
        int back = list.size() - 1;
        while (front < back) {
            if (!list.get(front).equals(list.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
