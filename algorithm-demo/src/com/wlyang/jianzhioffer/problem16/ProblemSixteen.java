package com.wlyang.jianzhioffer.problem16;

/**
 * @Description: 输入两个单调递增的链表，输出两个链表合成后的链表，
 *               当然我们需要合成后的链表满足单调不减规则。
 * @author: wlyang
 * @since: 2020-1-13
 */
public class ProblemSixteen {
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

        ListNode result =  Solution.Merge(n1,n2);
        System.out.println();
    }
}
class Solution {
    public static ListNode Merge(ListNode list1,ListNode list2) {
        //先建一个头节点
        ListNode head = new ListNode(-1);
        ListNode temp = head;

        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while(temp1!=null && temp2!=null){
            //比较当前节点谁更大
            if(temp1.val<=temp2.val){
                ListNode newNode = new ListNode(temp1.val);
                temp.next = newNode;
                temp1 = temp1.next;
            }else {
                ListNode newNode = new ListNode(temp2.val);
                temp.next = newNode;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1!=null){
            temp.next = temp1;
        }
        if(temp2!=null){
            temp.next = temp2;
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
