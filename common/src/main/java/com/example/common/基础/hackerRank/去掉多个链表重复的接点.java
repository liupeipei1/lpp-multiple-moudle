package com.example.common.基础.hackerRank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 去掉多个链表重复的接点 {

    public static void main(String[] args) {
        SinglyLinkedListNode a =
                new SinglyLinkedListNode(1, new SinglyLinkedListNode(2, new SinglyLinkedListNode(2
                        , new SinglyLinkedListNode(2, new SinglyLinkedListNode(6, new SinglyLinkedListNode(8, new SinglyLinkedListNode(7)))))));

        SinglyLinkedListNode b = new SinglyLinkedListNode(0);
        SinglyLinkedListNode r1 = deleteDuplicates(a);
        while (r1 != null) {
            System.out.println(r1.data);
            r1 = r1.next;
        }
        System.out.printf("=======================");
        SinglyLinkedListNode r = deleteDuplicates1(a);
        while (r != null) {
            System.out.println(r.data);
            r = r.next;
        }
    }

    public static SinglyLinkedListNode deleteDuplicates(SinglyLinkedListNode head) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(0);
        SinglyLinkedListNode cur = newNode;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            if (list.contains(head.data)) {
                head = head.next; //if exists，move to next one
                cur.next = head;//并且覆盖 cur.next  为了保证直插入不重复的node
            } else {
                list.add(head.data);
                cur.next = head;
                cur = cur.next;
                head = head.next;
            }
        }
        return newNode.next;
    }

    public static SinglyLinkedListNode deleteDuplicates1(SinglyLinkedListNode head) {
        List<Integer> potentialDuplicates = new ArrayList<>();
        SinglyLinkedListNode tempNode = new SinglyLinkedListNode(0);
        SinglyLinkedListNode currentNode = tempNode;
        while (head != null) {
            if (potentialDuplicates.contains(head.data)) {
                head = head.next;
                currentNode.next = head;
            } else {
                potentialDuplicates.add(head.data);
                currentNode.next = head;
                currentNode = currentNode.next;
                head = head.next;
            }
        }
        return tempNode.next;

    }
}
