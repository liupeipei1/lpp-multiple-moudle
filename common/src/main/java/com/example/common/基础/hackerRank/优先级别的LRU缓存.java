package com.example.common.基础.hackerRank;

import java.util.*;
/*
要实现 Priority-Aware LRU Cache 并满足 O(1) 时间复杂度的操作
需结合「哈希表 + 双向链表 + 优先级分组」
CacheEntry：存储每个缓存项的 value、priority、prev/next 指针（双向链表节点）。
PriorityGroup：为每个优先级维护一个 双向链表（按「最近使用时间」排序）和 哈希表（快速定位节点），实现 LRU 逻辑。
GlobalMap：全局哈希表，存储 key → CacheEntry，实现 O(1) 查找。
PriorityQueue：维护所有存在的优先级（按升序排列），快速找到「最低优先级」

操作逻辑：
put：插入 / 更新缓存项，若容量不足则淘汰「最低优先级中最久未使用」的项。
get：访问缓存项，将其移到对应优先级链表的头部（标记为最近使用）。
updatePriority：将缓存项从原优先级链表移除，插入新优先级链表的头部。。
 */
public class 优先级别的LRU缓存 {
    private int capacity;
    private Map<Integer, CacheEntry> globalMap; // key → CacheEntry
    private Map<Integer, PriorityGroup> priorityGroups; // priority → PriorityGroup
    private TreeSet<Integer> activePriorities; // 已存在的优先级（升序）

    public 优先级别的LRU缓存(int capacity) {
        this.capacity = capacity;
        this.globalMap = new HashMap<>();
        this.priorityGroups = new HashMap<>();
        this.activePriorities = new TreeSet<>();
    }

    // 获取缓存项
    public int get(int key) {
        if (!globalMap.containsKey(key)) {
            return -1; // 题目中未说明未命中返回值，按示例默认返回-1（实际需看题目要求）
        }
        CacheEntry node = globalMap.get(key);
        PriorityGroup group = priorityGroups.get(node.priority);
        // 移到头部（标记为最近使用）
        group.moveToHead(node);
        return node.value;
    }

    // 插入/更新缓存项
    public void put(int key, int value, int priority) {
        if (globalMap.containsKey(key)) {
            // 更新已存在的项
            CacheEntry node = globalMap.get(key);
            PriorityGroup oldGroup = priorityGroups.get(node.priority);
            // 移除原优先级组
            oldGroup.removeNode(node);
            if (oldGroup.isEmpty()) {
                activePriorities.remove(node.priority);
            }
            // 更新值和优先级
            node.value = value;
            node.priority = priority;
        } else {
            // 新增项：检查容量
            if (globalMap.size() >= capacity) {
                evict(); // 淘汰最低优先级的LRU项
            }
            // 创建新节点
            globalMap.put(key, new CacheEntry(key, value, priority));
        }

        // 加入新优先级组
        CacheEntry node = globalMap.get(key);
        priorityGroups.putIfAbsent(priority, new PriorityGroup());
        PriorityGroup newGroup = priorityGroups.get(priority);
        newGroup.addToHead(node);
        activePriorities.add(priority);
    }

    // 更新缓存项的优先级
    public void updatePriority(int key, int newPriority) {
        if (!globalMap.containsKey(key)) {
            return;
        }
        CacheEntry node = globalMap.get(key);
        int oldPriority = node.priority;
        if (oldPriority == newPriority) {
            return;
        }

        // 从原优先级组移除
        PriorityGroup oldGroup = priorityGroups.get(oldPriority);
        oldGroup.removeNode(node);
        if (oldGroup.isEmpty()) {
            activePriorities.remove(oldPriority);
        }

        // 更新优先级并加入新组
        node.priority = newPriority;
        priorityGroups.putIfAbsent(newPriority, new PriorityGroup());
        PriorityGroup newGroup = priorityGroups.get(newPriority);
        newGroup.addToHead(node);
        activePriorities.add(newPriority);
    }

    // 淘汰最低优先级中最久未使用的项
    private void evict() {
        if (activePriorities.isEmpty()) {
            return;
        }
        // 找到最低优先级
        int lowestPriority = activePriorities.first();
        PriorityGroup group = priorityGroups.get(lowestPriority);
        // 移除该组的LRU项
        CacheEntry evictedNode = group.removeLRU();
        if (evictedNode != null) {
            globalMap.remove(evictedNode.key);
        }
        // 若该优先级组为空，移除优先级
        if (group.isEmpty()) {
            activePriorities.remove(lowestPriority);
        }
    }

    // 模拟缓存操作的函数
    public static List<Integer> simulatePriorityCache(int capacity, int numOperations,
                                                      List<String> operationTypes, List<Integer> keys,
                                                      List<Integer> values, List<Integer> priorities) {
        优先级别的LRU缓存 cache = new 优先级别的LRU缓存(capacity);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numOperations; i++) {
            String op = operationTypes.get(i);
            int key = keys.get(i);
            switch (op) {
                case "put":
                    int value = values.get(i);
                    int priority = priorities.get(i);
                    cache.put(key, value, priority);
                    break;
                case "get":
                    int res = cache.get(key);
                    result.add(res);
                    break;
                case "updatePriority":
                    int newPriority = priorities.get(i);
                    cache.updatePriority(key, newPriority);
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] operationTypes = {"put", "put", "get", "put", "get", "updatePriority", "put", "get", "get"};
        Integer[] keys = {1, 2, 1, 3, 2, 3, 4, 3, 4};
        Integer[] values = {10, 20, 0, 30, 0, 0, 40, 0, 0};
        Integer[] priorities = {1, 2, 0, 1, 0, 3, 1, 0, 0};

        List<Integer> rs = simulatePriorityCache(2, 9, Arrays.asList(operationTypes),
                Arrays.asList(keys),
                Arrays.asList(values),
                Arrays.asList(priorities)
        );

        for (Integer key : rs) {
            System.out.println(key);
        }
    }
}
