package com.example.common.基础.leetcode.链表;

import java.util.HashSet;

/*
 给你一个链表的头节点 head ，判断链表中是否有环。
如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 */
public class 环形链表 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4, new ListNode(5)))));
        boolean rs = hasCycle(l1);
        System.out.printf("rs = %s\n", rs);
    }


    //hash哈希表
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        HashSet<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    //solution 2 快慢指针
    public static boolean solution(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;

    }
}
