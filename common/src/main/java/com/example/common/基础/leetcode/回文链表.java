package com.example.common.基础.leetcode;

import java.util.HashSet;

/*
 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class 回文链表 {


    public static void main(String[] args) {
        ListNode l1= new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1))));
        System.out.printf("rs:"+ solution(l1));

        ListNode l2= new ListNode(1,new ListNode(2));
        System.out.printf("rs:"+ solution(l2));
    }


    public static boolean solution(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        //循环该单链表
        ListNode temp = head;
        HashSet<Integer> set = new HashSet<>();
        while (temp.next != null) {
            if (set.contains(temp.val)) {
                return true;
            }
            set.add(temp.val);
            temp = temp.next;
        }

        return false;
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
