package com.wlyang.jianzhioffer.problem15;

/**
 * @Description:
 * 输入一个链表，反转链表后，输出新链表的表头。
 * @author: wlyang
 * @since: 2020-1-8
 */
public class ProblemFifteen {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode result = Solution.ReverseList(n1);
        System.out.println();
    }
}

class Solution {
    public static ListNode ReverseList(ListNode head) {
        if(head == null || head.next ==null){
            return head;
        }
        //定义一个头节点("-1")
        ListNode insertHead = new ListNode(-1);
        insertHead.next = head;
        ListNode p = head;
        ListNode pNext = p.next;
        while (pNext!=null){
            p.next = pNext.next;
            pNext.next = insertHead.next;
            insertHead.next = pNext;
            pNext = p.next;
        }
        return insertHead.next;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}