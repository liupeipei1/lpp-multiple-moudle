package com.example.common.基础.hackerRank;

import java.util.HashMap;
import java.util.Map;

public class PriorityGroup {
    // 双向链表的哨兵节点（head.next 是最近使用，tail.prev 是最久未使用）
    CacheEntry head;
    CacheEntry tail;
    // 快速定位节点（key → CacheEntry）
    Map<Integer, CacheEntry> nodeMap;


    PriorityGroup() {
        this.head = new CacheEntry(-1, -1, -1);
        this.tail = new CacheEntry(-1, -1, -1);
        head.next = tail;
        tail.prev = head;
        this.nodeMap = new HashMap<>();
    }

    // 将节点移到链表头部（标记为最近使用）
    void moveToHead(CacheEntry node) {
        // 先移除节点
        removeNode(node);
        // 插入到头部
        addToHead(node);
    }

    void removeNode(CacheEntry node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        nodeMap.remove(node.key);
    }

    //head-a-b  -》   head-node-a-b
    void addToHead(CacheEntry node) {
        node.next=head.next;//将a成为node后驱
        node.prev=head;
        head.next=node;
        head.next.prev=node;
        nodeMap.put(node.key, node);
    }

    // 获取并移除最久未使用的节点（链表尾部）
    CacheEntry removeLRU() {
        CacheEntry lruNode = tail.prev;
        if (lruNode != head) {
            removeNode(lruNode);
            return lruNode;
        }
        return null;
    }

    // 判断该优先级是否有节点
    boolean isEmpty() {
        return head.next == tail;
    }
}
