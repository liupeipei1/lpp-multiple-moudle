package com.example.common.基础.leetcode.链表;

import java.util.HashSet;
import java.util.Set;

public class 相交链表 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4, l1);
        ListNode l3 = new ListNode(8, l2);
        ListNode l4 = new ListNode(1, l3);
        ListNode headA = new ListNode(4, l4);
        ListNode l6 = new ListNode(1, l3);
        ListNode l7 = new ListNode(6, l6);
        ListNode headB = new ListNode(5, l7);
        ListNode rs = getIntersectionNode(headA, headB);
        while (rs != null) {
            System.out.printf("cur:" + rs.val);
            rs = rs.next;
        }

        ListNode rs1= getInterstedNode(headA, headB);
        while (rs1 != null) {
            System.out.printf("cur:" + rs1.val);
            rs1 = rs1.next;
        }
    }

    /*
      hash集合解法
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = headA;
        while (cur != null) {  //便利A
            set.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }
        return cur;
    }

    //双指针 时间复杂度：O(m+n)，其中 m 和 n 是分别是链表 headA 和 headB 的长度。
    //每步操作需要同时更新指针 pA 和 pB。
    public static ListNode getInterstedNode(ListNode headA, ListNode headB) {
        if(headB == null || headA == null) {
            return null;
        }
        ListNode pa=headA,pb=headB;
        while (pa!= pb){
            pa=pa==null? headA:pa.next;
            pb=pb==null? headB:pb.next;
        }
        return pa;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int var, ListNode var1) {
        this.val = var;
        this.next = var1;
    }
}
