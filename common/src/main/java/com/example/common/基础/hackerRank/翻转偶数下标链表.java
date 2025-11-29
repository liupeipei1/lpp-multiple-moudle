package com.example.common.基础.hackerRank;

/*
 Given a singly linked list, extract all even-indexed nodes, reverse their order,
  and append them to the end of the list in one traversal. Return the head of the modified list.
  将链表 偶数下标的 翻转
  偶数下标的保持原样
 */
public class 翻转偶数下标链表 {
    public static void main(String[] args) {
        SinglyLinkedListNode r1=  extractAndAppendSponsoredNodes(new SinglyLinkedListNode(1,new SinglyLinkedListNode(2)));
        //SinglyLinkedListNode r1 = extractAndAppendSponsoredNodes(new SinglyLinkedListNode(10,
         //       new SinglyLinkedListNode(20, new SinglyLinkedListNode(30, new SinglyLinkedListNode(40, new SinglyLinkedListNode(50,
            //            new SinglyLinkedListNode(60)))))));

        while (r1 != null) {
            System.out.println(r1.data);
            r1 = r1.next;
        }
    }

    public static SinglyLinkedListNode extractAndAppendSponsoredNodes(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //将链表分为奇数
        SinglyLinkedListNode evenNodes = new SinglyLinkedListNode(0);
        SinglyLinkedListNode evenHead = evenNodes;
        SinglyLinkedListNode oddNodes = new SinglyLinkedListNode(0);
        SinglyLinkedListNode oddHead = oddNodes;
        int index = 0;
        while (head != null) {
            if (index % 2 == 0) {
                evenHead.next = new SinglyLinkedListNode(head.data);
                head = head.next;
                evenHead = evenHead.next;
            } else {
                oddHead.next = new SinglyLinkedListNode(head.data);
                head = head.next;
                oddHead = oddHead.next;
            }
            index++;
        }

        //reverse even-indexed nodes
        SinglyLinkedListNode evenNew = reverseNodes(evenNodes.next);
        oddHead.next = evenNew;
        return oddNodes.next;
    }

    public static SinglyLinkedListNode reverseNodes(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        SinglyLinkedListNode pre = null;
        SinglyLinkedListNode cur = head;
        while (cur != null) {
            SinglyLinkedListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
