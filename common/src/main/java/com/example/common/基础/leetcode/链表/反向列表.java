package com.example.common.基础.leetcode.链表;

/*
  给你单链表的头节点head  需要反转后的链表
 */
public class 反向列表 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode rs = reverse(l1);
        ListNode temp = rs;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    // 迭代 翻转  1->2->3->null   convert  null->3>2>1->null
    public static ListNode getReverseNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        ListNode pre = null;

        while (curr != null) {
            ListNode next  = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
   //same as above
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode pre = null;
        while(curr!=null){
            ListNode next = curr.next; //指向下一个
            curr.next = pre;//当前元素的下一个变成null
            pre=curr; //将pre+curr组装好的值 赋值给pre
            curr=next; //继续循环下一个单链表的值
        }
        return pre;


    }
}
