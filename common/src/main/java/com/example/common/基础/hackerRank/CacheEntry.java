package com.example.common.基础.hackerRank;

public class CacheEntry {
    int key;
    int value;
    int priority;
    CacheEntry prev;
    CacheEntry next;

    CacheEntry(int key, int value, int priority) {
        this.key = key;
        this.value = value;
        this.priority = priority;
        this.prev = null;
        this.next = null;
    }
}
