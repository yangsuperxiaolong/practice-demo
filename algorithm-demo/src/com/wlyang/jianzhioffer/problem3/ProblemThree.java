package com.wlyang.jianzhioffer.problem3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description: 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @author: wlyang
 * @since: 2020-1-7
 */
public class ProblemThree {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2; n2.next =n3; n3.next = n4; n4.next = n5;

        ArrayList<Integer> a =  Solution.printListFromTailToHead(n1);
        System.out.println(Arrays.toString(a.toArray()));
    }
}

class Solution {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode == null) {
            return result;
        }
        //写一下单链表反转
        ListNode head = new ListNode(-1);
        head.next = listNode;
        //temp指向链表第一个节点
        ListNode temp = listNode;
        //tempNext指向temp后一个节点
        ListNode tempNext = temp.next;
        while (tempNext != null) {
            //让temp节点指向后移2个节点位置，相当于把tempNext节点切出来了
            temp.next = tempNext.next;

            //把tempNext节点插入链表第一个位置
            tempNext.next = head.next;
            head.next = tempNext;

            //循环
            tempNext = temp.next;
        }

        //遍历
        ListNode a = head.next;
        while (a != null) {
            result.add(a.val);
            a = a.next;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
