package com.example.common.基础.leetcode.链表;

/*
 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class 删除链表倒数第n个节点 {
    public static void main(String[] args) {
        ListNode l3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode rs1 = removeNthFromEnd(l3, 2);
        while (rs1 != null) {
            System.out.println(rs1.val);
            rs1 = rs1.next;
        }

        ListNode rs2= removeNthFromEnd(new ListNode(1), 1);
        while (rs2 != null) {
            System.out.println(rs2.val);
            rs2 = rs2.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0); //哨兵节点 避免后面curr.next的空指针异常  当链表就一个数的时候。next.next会出现空指针
        dummy.next = head;
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; i++) {//被删除节点的前面的节点
            cur = cur.next;
        }
        cur.next = cur.next.next; //将删除的接点的下一个节点往前移  这里同时也会更新dummy对象的值
        return dummy.next;
    }

    public static Integer getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
