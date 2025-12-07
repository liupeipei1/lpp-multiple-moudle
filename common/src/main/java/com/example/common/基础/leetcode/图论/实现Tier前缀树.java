package com.example.common.基础.leetcode.图论;

/*
前缀树测试类
 */
public class 实现Tier前缀树 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("orange");
        trie.insert("grape");
        System.out.printf("\n" + trie.search("app"));
        System.out.printf("\n" + trie.startsWith("app"));
        System.out.printf("\n" + trie.search("tf"));

    }
}
