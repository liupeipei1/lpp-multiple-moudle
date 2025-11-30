package com.example.common.基础.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 复制带指针的链表 {
    public static void main(String[] args) {

    }
    static Map<Node, Node> map = new HashMap<>();
    static class Node {
        int val;
        Node next;
        Node random;
        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static Node copyRandomList(Node head) {
        if (head == null) return head;
        if(!map.containsKey(head)){
            Node newHead =new Node(head.val);
            map.put(head,newHead);
            newHead.next=copyRandomList(head.next);
            newHead.random=copyRandomList(head.random);
        }
        return map.get(head);
    }
}
