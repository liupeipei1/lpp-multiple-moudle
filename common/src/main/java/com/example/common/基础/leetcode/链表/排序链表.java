package com.example.common.基础.leetcode.链表;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class 排序链表 {
    public static void main(String[] args) {

        ListNode rs = sortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3)))));
        while (rs != null) {
            //System.out.printf("rs = %s\n", rs.val);
            rs = rs.next;
        }

        ListNode rs1 = sortList3(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3)))));
        while (rs1 != null) {
            System.out.printf("rs = %s\n", rs1.val);
            rs1 = rs1.next;
        }
    }

    //归并排序
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 1. 找到链表中点（用快慢指针）
        ListNode mid = findMiddle(head); //注意 这里的mid修改会影响head
        ListNode rightHead = mid.next;
        mid.next = null; // 拆分链表为左半部分（head）和右半部分（rightHead）

        // 2. 递归排序左右两部分
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 3. 合并两个有序链表（复用经典合并逻辑）
        return mergeTwoLists(left, right);

    }

    // 辅助方法：合并两个有序链表（升序） 因为在之前 已经将链表一分为二 所以这里可以忽略 两个链表长度 超过另外一个链表过多的情况
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        //存在剩下的
        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    // 辅助方法：快慢指针找链表中点（偶数个节点时取左中点）
    //慢指针走一步  快指针一下跳两步 由于快指针是慢指针的两倍 当走完快指针到达末尾时 慢指针刚好走到一半
    //4213
    public static ListNode findMiddle(ListNode head) {
        if (head == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //暴力
    public static ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        ListNode dummyHead = new ListNode(list.get(0));
        ListNode cur = dummyHead;//火车箱
        for (int i = 1; i < list.size(); i++) {
            ListNode newNode = new ListNode(list.get(i));//新车厢
            cur.next = newNode;
            cur = cur.next;
        }
        return dummyHead;
    }


    //链表的插入排序
    public static ListNode sortList3(ListNode head) {
        if (head == null) return null;
        // 结果链表的哨兵节点（始终指向排序后的链表头）
        ListNode dummyHead = new ListNode(0);
        ListNode cur = head; // 遍历原链表的指针
        while (cur != null) {
            // 每次插入前，重置结果链表的遍历指针
            ListNode pre = dummyHead;

            // 找到插入位置：pre.next.val > cur.val 时，插入到 pre 后面
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            // 保存原链表的下一个节点（防止断链）
            ListNode next = cur.next;

            // 将当前节点插入到结果链表的正确位置
            cur.next = pre.next;  //这里当前的cur大于pre的next的值 所以需要将cur的next变成一级钢排序号的pre
            pre.next = cur;//这里就是 将当前的cur+ 历史的pre
            // 继续遍历原链表的下一个节点
            cur = next;
        }
        return dummyHead.next;
    }
}
