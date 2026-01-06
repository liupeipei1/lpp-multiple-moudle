package com.example.common.基础.leetcode.链表;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheTest {

    public static void main(String[] args) {
        LRUCacheTest a = new LRUCacheTest(3);
        a.put(1, 1);
        a.put(2, 2);
        a.put(3, 3);
        LinkedTable temp = a.head;
        while (temp != null) {
            System.out.printf("===" + temp.value);
            temp = temp.next;
        }

        int value = a.get(3);
        System.out.printf("value:%d", value);
    }

    //双向链表
    /*
      1->2
      1<-2
     */
    class LinkedTable {
        int key;
        int value;
        LinkedTable pre;
        LinkedTable next;

        LinkedTable(int key, int value) {
            this.key = key;
            this.value = value;
        }

        LinkedTable() {
        }
    }


    int capacity;
    int size;
    Map<Integer, LinkedTable> map = new HashMap<>();
    LinkedTable head;
    LinkedTable tail;

    public LRUCacheTest(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new LinkedTable();
        this.tail = new LinkedTable();
        head.next = tail;
        tail.pre = head;
    }

    public void put(int key, int value) {
        LinkedTable linkedTable = map.get(key);
        if (linkedTable == null) {
            LinkedTable newNode = new LinkedTable(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                //remove 不常用的尾巴
                LinkedTable rs = removeTail();
                map.remove(rs.key);
                size--;
            }
        } else {
            linkedTable.value = value;
            //将当前的元素移到前面
            moveToHead(linkedTable);
        }
    }

    //head-》A->B -》C  ->   head-node->A-》B
    //注意这里需要按照顺序来 否则就会出问题
    public void addToHead(LinkedTable node) {
        node.pre = head;//绑定head
        node.next = head.next;//head.next=A
        head.next.pre = node;//让A 认node为前驱
        head.next = node; //当node成为head后驱
    }

    public LinkedTable removeTail() {
        LinkedTable node = tail.pre;//tail是哨兵节点  往前就是删除需要删除的接点
        return removeNode(node);
    }

    //1-2-3
    public LinkedTable removeNode(LinkedTable node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return node;
    }

    public void moveToHead(LinkedTable node) {
        //删除当前
        removeNode(node);
        addToHead(node);
    }

    public int get(int key) {
        LinkedTable linkedTable = map.get(key);
        if (linkedTable == null) {
            return -1;
        }
        //movetoHead
        moveToHead(linkedTable);
        return linkedTable.value;
    }

}
