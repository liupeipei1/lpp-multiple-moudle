package com.example.common.基础.leetcode.图论;

/*
  实现前缀数 判断字符是否存在 是否需要补齐
 */
public class Trie {
    boolean isWord;// 2. 结束标记：布尔值，标记当前节点是否是某个字符串的结尾
    Trie[] children; // 1. 子节点数组：存的是「其他TrieNode的引用」，不是布尔值！ 存储下一层节点的引用，构建字符路径


    Trie() {
        children = new Trie[26];// 初始化：长度26（对应a-z），每个元素默认是null（引用类型数组的默认值）
        this.isWord = false;
    }

    /*
             根节点（空）
        └─ a（索引0，isEnd=false）
           └─ p（索引15，isEnd=false）
              └─ p（索引15，isEnd=true）
                 └─ l（索引11，isEnd=false）→ 第4个字符：l
                    └─ e（索引4，isEnd=true）→ 第5个字符：e（标记结束）
        └─O
        当存储的第二个字符串的时候 没找到共同的路径 那么就会在children index生成新的一个 所以这就是为啥定义成26位数组 为了一层层指向路径
     */
    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Trie();
            }
            cur = cur.children[index]; //将curr指向另外一个新的 字符对象
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public Trie searchPrefix(String prefix) {
        Trie cur = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (cur.children[index] == null) {
                return null;
            }
            cur = cur.children[index];
        }
        return cur;
    }
}
