package com.wlyang.linkedlist;

/**
 * @Description: 双向链表
 * @author: wlyang
 * @since: 2019-12-6
 */
public class DoublyLinkList {
    private DoublyNode head;

    public DoublyLinkList() {
        head = new DoublyNode(-1, "");
    }

    /**
     * 实现双向链表的增删改查
     */
    public void add(DoublyNode node) {
        DoublyNode temp = head;
        //找到尾节点
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
        node.setPre(temp);
    }

    /**
     * 实现双向链表遍历
     */
    public void show() {
        DoublyNode temp = head;
        if (isEmpty()) {
            throw new RuntimeException("链表为空");
        }

        while (temp.getNext() != null) {
            temp = temp.getNext();
            System.out.println(temp);
        }
    }

    /**
     * 删除id为 n的节点(最靠近头节点的一个)
     *
     * @param n
     */
    public void delete(int n) {
        if (isEmpty()) {
            throw new RuntimeException("链表为空！");
        }
        DoublyNode temp = head.getNext();
        //找到尾节点
        while (temp != null) {
            if (n == temp.getId()) {
                temp.getPre().setNext(temp.getNext());
                if (temp.getNext() != null) {
                    temp.getNext().setPre(temp.getPre());
                }
                return;
            }
            temp = temp.getNext();
        }
        throw new RuntimeException("节点不存在！");
    }

    /**
     * 按序插入
     *
     * @param node
     */
    public void addByOrder(DoublyNode node) {
        DoublyNode temp = head;
        //找到正确位置，在temp后插入
        while (temp.getNext() != null && node.getId() >= temp.getNext().getId()) {
            if (node.getId() == temp.getId()) {
                throw new RuntimeException("节点已存在，添加失败");
            }
            temp = temp.getNext();
        }
        if (temp.getNext() != null) {
            temp.getNext().setPre(node);
            node.setPre(temp);
            node.setNext(temp.getNext());
            temp.setNext(node);
        }else{
            temp.setNext(node);
            node.setPre(temp);
        }
    }

    public Boolean isEmpty() {
        if (head.getNext() == null) {
            return true;
        }
        return false;
    }

}
