package com.example.common.基础.leetcode;

//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
public class 两两交换链表中的节点 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode rs = swapPairs(l1);
        ListNode temp = rs;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    //递归的终止条件是链表中没有节点，或者链表中只有一个节点，此时无法进行交换。
    //如果链表中至少有两个节点，则在两两交换链表中的节点之后，原始链表的头节点变成新的链表的第二个节点，
    // 原始链表的第二个节点变成新的链表的头节点。链表中的其余节点的两两交换可以递归地实现。在对链表中的其余节点递归地两两交换之后，
    // 更新节点之间的指针关系，即可完成整个链表的两两交换。
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;//2345  保存当前轮第二个节点（交换后会成为子链表头）
        head.next = swapPairs(newHead.next);//递归处理后续链表，让当前第一个节点的 next 指向后续交换后的结果
        newHead.next = head;//交换当前两个节点：让第二个节点的 next 指向第一个节点
        return newHead;
    }
}
