package com.example.common.基础.hackerRank;

import java.util.Objects;

/*
 One-Pass Removal of k-th Node from End
Given the head of a singly linked list and an integer k,
remove the k-th node from the end in one traversal and return the new head.
If k is invalid, return the original list.
将返回倒数第k位的接点
head = [5, 6, 7, 8]
k = 3
output:[6, 7, 8]
 */
public class 移除最后k个接点链表 {
    public static void main(String[] args) {
        SinglyLinkedListNode case1 = new SinglyLinkedListNode(5, new SinglyLinkedListNode(6, new SinglyLinkedListNode(7, new SinglyLinkedListNode(8))));
        SinglyLinkedListNode case2 = new SinglyLinkedListNode(5);
        SinglyLinkedListNode case3 = new SinglyLinkedListNode(1, new SinglyLinkedListNode(2));
        SinglyLinkedListNode case4 = new
                SinglyLinkedListNode(1,
                new SinglyLinkedListNode(2,new SinglyLinkedListNode(3,new SinglyLinkedListNode(4,new SinglyLinkedListNode(5)))));

        SinglyLinkedListNode node1 = removeKthNodeFromEnd(case4, 3);

        //SinglyLinkedListNode node = removeKthNodeFromEnd(new SinglyLinkedListNode(1), 1);
        while (node1 != null) {
            System.out.printf("===" + node1.data);
            node1 = node1.next;
        }
    }

    //solution 1
    public static SinglyLinkedListNode removeKthNodeFromEnd1(SinglyLinkedListNode head, int k) {
        if (Objects.isNull(head)) {
            return head;
        }
        SinglyLinkedListNode leader = head;
        SinglyLinkedListNode follower = head;

        for (int i = 0; i <= k; i++) { // i = 3, leader = 8
            leader = leader.next; // leader=8

            if (leader == null) {
                if (i == k) {
                    return head.next;
                } else {
                    return head;
                }
            }
        }

        while (leader.next != null) {
            leader = leader.next;
            follower = follower.next;
        }

        follower.next = follower.next.next;

        return head;
    }

    //solution2
    public static SinglyLinkedListNode removeKthNodeFromEnd(SinglyLinkedListNode head, int k) {
        // Write your code here
        if (head == null) return head;
        int count = 0;
        SinglyLinkedListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        //无效数判断
        if (k < 0 || k >= count) {
            return head;
        }
        int indexToDelete = count - k - 1; //倒数第k个节点的正序索引为count - k（从 0 开始）比如size=4 k=3 4-3=1 目前是第二个数才是需要返回的
        //indexTodelete 前驱节点索引
        if (indexToDelete == 0) {
            return head.next;
        }
        SinglyLinkedListNode current = head;
        for (int j = 0; j < indexToDelete - 1; j++) { //前驱点的前驱点
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
        return head;
    }

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }


        SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
            this.data = data;
            this.next = next;
        }
    }
}
