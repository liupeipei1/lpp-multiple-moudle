package com.example.common.基础.leetcode.链表;

/*
 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
 */
public class 两数相加 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode rs = addTwoNumbers(l1, l2);
        while (rs != null) {
            System.out.println(rs.val);
            rs = rs.next;
        }

        System.out.printf("============\n");

        ListNode l3 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode l4 = new ListNode(9, new ListNode(9, new ListNode(9)));

        ListNode rs1 = addTwoNumbers(l3, l4);
        while (rs1 != null) {
            System.out.println(rs1.val);
            rs1 = rs1.next;
        }
    }

    //243  +  584 = 708
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = null, tail = null;
        int carry = 0;//进位符
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = new ListNode(sum % 10); //得到个位数（余数） 当小于10则是本身 这里head tail的指向节点是一个对象
                tail = head;
            } else {
                tail.next = new ListNode(sum % 10);//将新的车厢添加到火车头
                tail = tail.next;//继续往后添加
            }
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            if (carry > 0) {
                tail.next = new ListNode(carry % 10); //当进位的时候需要往后面加1
            }
        }
        return head;
    }
}
