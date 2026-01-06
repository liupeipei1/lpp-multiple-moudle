package com.example.common.基础.leetcode.链表;

import java.util.HashMap;
import java.util.Map;

//请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
//hash集合+ 双向链表
public class LRUCache {
    //建立一个双向链表
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
        DLinkedNode() {
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    //哈希表+ 链表的方式实现
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }


    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void moveToHead(DLinkedNode node) {
        removeNode(node);//先删除自己的接点
        addToHead(node);//然后和head调换顺序
    }

    /*
       1- 2- 3
       当删除2的接点
       那么2的上一个节点（1）的next  =   当前节点（2）的下一个节点
       那么当前节点的下一个值的 pre = 当前节点（2）的上一个pre
     */
    public void removeNode(DLinkedNode node) {
        node.pre.next = node.next;//移除当前节点   价格当前的接点 等于 下一个节点
        node.next.pre = node.pre; //将当前的接点的pre 换成前一个接点的pre
    }


    //head（哨兵） <-> A <-> B <-> C  ->  head <-> node <-> A <-> B <-> C
    public void addToHead(DLinkedNode node) {
        node.pre = head;//head是一个哨兵是空的,要让 node 成为 head 的直接后继
        node.next = head.next;//head.next 是 A，所以这行代码等价于 node.next = A：
        head.next.pre = node; // 让 A 认 node 为前驱
        head.next = node;// 让 head 认 node 为后继
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value); //如果key不存在 需要创建一个新的节点
            cache.put(key, newNode);
            //添加至头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                //超出容量 需要删除双链表尾巴
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }

    }

    public DLinkedNode removeTail() {
        DLinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }

    public static void main(String[] args) {
        LRUCache a = new LRUCache(2);
        a.put(1, 1);
        a.put(2, 2);
        a.put(3, 3);
        DLinkedNode temp = a.head;
        while (temp != null) {
            System.out.printf("===" + temp.value);
            temp = temp.next;
        }

        int value = a.get(3);
        System.out.printf("value:%d", value);
    }
}
