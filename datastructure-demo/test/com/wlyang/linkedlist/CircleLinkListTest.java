package com.wlyang.linkedlist;

/**
 * @Description:
 * @author: wlyang
 * @since: 2019-12-10
 */
public class CircleLinkListTest {
    public static void main(String[] args) {
        CircleLinkList circleLinkList = new CircleLinkList();
        circleLinkList.add(new Node(4,"循环链表节点4"));
        circleLinkList.add(new Node(1,"循环链表节点1"));
        circleLinkList.add(new Node(3,"循环链表节点3"));
        circleLinkList.add(new Node(2,"循环链表节点2"));
        circleLinkList.add(new Node(5,"循环链表节点5"));
        System.out.println("删除前");
        circleLinkList.show();

        circleLinkList.delete(5);
        System.out.println("删除后");
        circleLinkList.show();

    }
}
