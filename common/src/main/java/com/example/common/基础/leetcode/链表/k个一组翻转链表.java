package com.example.common.基础.leetcode.链表;
/*
 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
  1->2->3-4-5 k=2 也就是每两组进行翻转
  2-1-4-3-5

  1-2-3-4-5  k=3
  3-2-1-4-5
 */

public class k个一组翻转链表 {
    public static void main(String[] args) {
        ListNode rs = reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4,new ListNode(5))))), 2);
        while (rs != null) {
            System.out.printf("rs = %s\n", rs.val);
            rs = rs.next;
        }
        ListNode rs1 = reverseKGroup2(new ListNode(1, new ListNode(2, new ListNode(3))), 2);
        while (rs1 != null) {
            System.out.printf("rs = %s\n", rs1.val);
            rs1 = rs1.next;
        }
    }

    //k的控制 翻转 「哨兵节点 + 尾指针」 跟踪每组翻转后的尾部，再连接下一组：
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy; // 上一组的尾部
        ListNode end = dummy; // 当前组的尾部

        while (end.next != null) {
            // 移动end到当前组的第k个节点
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break; // 剩余节点不足k

            ListNode start = pre.next; // 当前组的头节点
            ListNode nextGroup = end.next; // 下一组的头节点

            end.next = null; // 截断当前组
            pre.next = reverseNode(start, k); // 翻转当前组并连接

            start.next = nextGroup; // 连接下一组
            pre = start; // pre移动到当前组的尾部（原start）
            end = pre; // end重置为pre
        }
        return dummy.next;
    }

    //1-2-3-null
    //null<1<<2<3   012
    public static ListNode reverseNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;//当前元素的下一个变成null
            pre = cur; //将pre+curr组装好的值 赋值给pre
            cur = next;
        }
        return pre;
    }


    /*
      这里的目的就是将整个全量Node节点 只在k的范围中翻转
      1  2  3
      第一次循环 cur.next = pre  将cur 的1的next变成null 这里同时也改变了head 1 的next也是空 因为对象地址是一样
     */
    public static ListNode reverseNode(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null && k > 0) {
            ListNode next = cur.next;
            cur.next = pre;//当前元素的下一个变成null 这里同时也会更新head的值
            pre = cur; //将pre+curr组装好的值 赋值给pre
            cur = next; //后面就不是不会因为cur的赋值 而改变head值，因为cur循环指向了新的下一个节点了
            k--;
        }
        return pre;
    }

    /* 这个比较容易理解
      方法1：递归+分组翻转
      先检查剩余节点是否大于等于K 若是则需要翻转
      若不是则返回当前头结点
     */
    public static ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null) return head;

        //检查剩余节点是否大于等于K
        ListNode cur = head; //相当于循环里面的一个变量  head相当于是一个list 在这里不会改变head的值
        int count = 0;
        while (cur != null && count < k) {
            count++;
            cur = cur.next;
        }
        if (count < k) {
            return head; //返回剩余节点
        }

        //翻转当前k个节点
        ListNode newHead = reverseNode(head, k);

        //递归剩余处理部分 连接到当前翻转后的尾巴  注意这里head当前值是1， 因为翻转12-》 21  所以当前的head就是尾巴
        //注意这的head是newhead最后一个子节点 所以 将head.next = 需要的值 这样才能拼接上
        head.next = reverseKGroup2(cur, k);
        return newHead;//因为head.next=x 已经拼接上了上一个值 所以返回newhead
    }
}
