package com.wlyang.linkedlist;

class LinkList {
    private Node head;

    public LinkList() {
        head = new Node(-1, "");
    }

    public void add(Node node) {
        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
    }
    /**
     * description: 按序添加节点 <br>
     * 
     * @param node 新增节点
     * @return void
     */ 
    public void addByOrder(Node node) {
        Node temp = head;
        if (temp.getNext() == null) {
            temp.setNext(node);
            return;
        }
        while (temp.getNext() != null) {
            if (temp.getNext().getId() == node.getId()) {
                System.out.println("节点存在");
                return;
            } else if (temp.getNext().getId() > node.getId()) {
                //插入
                node.setNext(temp.getNext());
                temp.setNext(node);
                return;
            } else {
                temp = temp.getNext();
            }
        }
        temp.setNext(node);
    }
    /**
     * description: 遍历查看链表 <br>
     * 
     * @param
     * @return void
     */ 
    public void show() {
        Node temp = head.getNext();
        if (temp == null) {
            System.out.println("链表为空");
            return;
        }
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.getNext();
        }

    }
}
