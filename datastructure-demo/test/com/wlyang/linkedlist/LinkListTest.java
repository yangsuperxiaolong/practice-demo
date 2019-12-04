package com.wlyang.linkedlist;

public class LinkListTest {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.addByOrder(new Node(1,"节点1"));
        list.addByOrder(new Node(3,"节点3"));
        list.addByOrder(new Node(2,"节点2"));
        list.show();
        Node kNode = list.getBackwords(4);
        System.out.println("knode="+kNode.getId());
        System.out.println(list.size());
    }
}
