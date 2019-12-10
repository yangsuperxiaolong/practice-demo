package com.wlyang.linkedlist;

/**
 * @Description:
 * @author: wlyang
 * @since: 2019-12-6
 *
 */
public class DoublyLinkListTest {
    public static void main(String[] args) {
        DoublyLinkList doublyLinkList = new DoublyLinkList();
        doublyLinkList.add(new DoublyNode(1,"双向节点1"));
        doublyLinkList.add(new DoublyNode(3,"双向节点3"));
        doublyLinkList.add(new DoublyNode(2,"双向节点2"));
        doublyLinkList.add(new DoublyNode(5,"双向节点5"));
        doublyLinkList.show();

        doublyLinkList.delete(5);
        System.out.println("删除节点5之后");
        doublyLinkList.show();

        doublyLinkList.addByOrder(new DoublyNode(4,"节点4"));
        System.out.println("按序加入节点4");
        doublyLinkList.show();


    }
}
