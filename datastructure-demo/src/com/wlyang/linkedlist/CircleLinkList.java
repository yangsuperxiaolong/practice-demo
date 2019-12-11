package com.wlyang.linkedlist;

/**
 * @Description: 循环链表
 * @author: wlyang
 * @since: 2019-12-10
 */
public class CircleLinkList {
    private Node first;

    /**
     * 实现循环链表节点添加
     */
    public void add(Node node) {
        if (first == null) {
            node.setNext(node);
            first = node;
        } else {
            Node temp = first;
            while (temp.getNext() != first) {
                temp = temp.getNext();
            }
            //在temp后插入
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
    }

    /**
     *
     * 实现循环链表节点遍历
     */
    public void show() {
        if (first == null) {
            throw new RuntimeException("链表为空！");
        }
        Node temp = first;
        while (true) {
            System.out.println(temp);
            if (temp.getNext() == first) {
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 实现循环链表节点删除
     * “单向链表”(只有next域)，如果要删除节点，必须要定位到删除节点的前一个节点
     */
    public void delete(int id) {
        if (first == null) {
            throw new RuntimeException("链表为空！");
        }
        Node temp = first;
        //如果只有一个元素 并且当前节点就是需要删除的
        if (temp.getId() == id && temp.getNext() == first) {
            first = null;
            return;
        }
        while (temp.getNext() != first) {
            if (temp.getNext().getId() == id) {
                temp.setNext(temp.getNext().getNext());
                return;
            } else {
                temp = temp.getNext();
            }
        }
        if (temp.getNext().getId() == id) {
            //如果是删除first节点，说明要把first节点后移一位
            temp.setNext(temp.getNext().getNext());
            first = temp.getNext();
        } else {
            throw new RuntimeException("删除节点不存在");
        }
    }

    public Node getFirst(){
        return first;
    }
}
