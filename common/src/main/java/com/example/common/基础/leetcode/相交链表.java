package com.example.common.基础.leetcode;

public class 相交链表 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2= new ListNode(4,l1);
        ListNode l3 = new ListNode(8,l2);
        ListNode l4 = new ListNode(1,l3);
        ListNode headA = new ListNode(4,l4);
        ListNode l6 = new ListNode(1,l3);
        ListNode l7 = new ListNode(6,l6);
        ListNode headB = new ListNode(5,l7);
        ListNode rs = getIntersectionNode(headA,headB);



    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return null;

    }
}
