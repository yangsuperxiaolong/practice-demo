package com.wlyang.linkedlist;

/**
 * @Description:
 * @author: wlyang
 * @since: 2019-12-10
 */
public class CircleLinkListTest {
    public static void main(String[] args) {
        CircleLinkList circleLinkList = new CircleLinkList();
        circleLinkList.add(new DoublyNode(1,"双向节点1"));
        circleLinkList.add(new DoublyNode(3,"双向节点3"));
        circleLinkList.add(new DoublyNode(2,"双向节点2"));
        circleLinkList.add(new DoublyNode(5,"双向节点5"));
        circleLinkList.show();

    }
}
