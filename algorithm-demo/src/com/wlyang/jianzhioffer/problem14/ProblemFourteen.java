package com.wlyang.jianzhioffer.problem14;

/**
 * @Description: 输入一个链表，输出该链表中倒数第k个结点。
 * @author: wlyang
 * @since: 2020-1-8
 */
public class ProblemFourteen {
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

        ListNode result = Solution.FindKthToTail(n1, 6);
        System.out.println();
    }
}

class Solution {
    public static ListNode FindKthToTail(ListNode head, int k) {
        //数据校验 k >=0，小于链表长度
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (q!=null) {
                q = q.next;
                count++;
            }
        }
        if(count<k){
            return null;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        return p;

    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}