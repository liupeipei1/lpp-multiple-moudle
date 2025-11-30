package com.example.common.基础.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//1-2-4
//1-3-4
//1-1-2-3-4-4
public class 合并两个有序链表 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode = mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

        ListNode listNode1 = mergeTwoLists2(l1, l2);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        List<Integer> list = new ArrayList<>();
        while (list1 != null) {
            list.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            list.add(list2.val);
            list2 = list2.next;
        }
        Collections.sort(list);
        //重点：（head 和 tail 是两个不同的引用，但都指向同一个节点）
        //整个过程中，火车头（head）从没动过，但火车的长度在增加（后续车厢越来越多）—— 你看到的「更新」，其实是火车变长了，而非火车头变了。
        ListNode head = new ListNode(list.get(0));   // 1. 创建头节点（list 第一个元素） 相当于创建火车头
        ListNode tail = head; // tail 初始指向头节点（此时链表只有头节点） 先指向火车头（此时火车只有车头）；
        for (int i = 1; i < list.size(); i++) {
            ListNode cur = new ListNode(list.get(i));
            tail.next = cur; // 新节点挂到链表尾部  给 tail 指向的节点（A）的 next 赋值，让 A.next 指向 B
            tail = cur; // 把 tail 移到新挂的车厢上（tail = cur），方便下一次挂新车厢 tail 现在指向 B
        }
        return head;
    }

    //方法2递归  这里因为两个链表是升序的方式  如果是无序的 返回的结果也是无序的、
    //贪心  每次选最小的数
    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {//确保了「当前层返回的节点是两个链表中最小的」，这是排序的基础；
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        }
    }
}
