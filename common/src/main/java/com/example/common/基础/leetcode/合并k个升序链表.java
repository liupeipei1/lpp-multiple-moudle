package com.example.common.基础.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 合并k个升序链表 {
    public static void main(String[] args) {
      ListNode[] nodes = new ListNode[3];
      nodes[0] = new ListNode(1,new ListNode(4,new ListNode(5)));
        nodes[1] = new ListNode(1,new ListNode(3,new ListNode(4)));
        nodes[2] = new ListNode(2,new ListNode(6));
        //ListNode r= mergeKLists(nodes);
        ListNode r= mergeKLists1(nodes);
        while (r != null) {
            System.out.println(r.val);
            r=r.next;
        }

    }

    //solution 1暴力 可用
    public static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
       //遍历所有的node
        for (ListNode listNode : lists) {
            ListNode cur = listNode;
            while (cur != null) {
                list.add(cur.val);
                cur = cur.next;
            }
        }
        //排序
        Collections.sort(list);
        //组装
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 0; i < list.size(); i++) {
            ListNode temp = new ListNode(list.get(i));
            cur.next = temp;
            cur = cur.next;
        }
        return head.next;
    }

    //顺序合并
    /*
      先声明一个空的node然后进行 对数组第一个进行比较，得到第一轮 null + node[0]
      第二次循环德奥 ans(第一轮比较过后的值) 与node[1] 进行比较 然后得到 新的ans
     */
    public static ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode ans= null;
        for (int i = 0; i < lists.length; i++) {
            ans=  mergeTwoList(ans,lists[i]);
        }
      return ans;
    }

    public static ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = list1, bPtr = list2;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val <= bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            }else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = aPtr != null ? aPtr : bPtr;
        return head.next;
    }
}
