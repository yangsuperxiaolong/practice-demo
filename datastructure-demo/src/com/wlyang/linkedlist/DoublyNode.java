package com.wlyang.linkedlist;

/**
 * @Description: 双向节点
 * @author: wlyang
 * @since: 2019-12-6
 */
public class DoublyNode {
    private int id;
    private String name;
    private DoublyNode next;
    private DoublyNode pre;

    public DoublyNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DoublyNode getNext() {
        return next;
    }

    public void setNext(DoublyNode next) {
        this.next = next;
    }

    public DoublyNode getPre() {
        return pre;
    }

    public void setPre(DoublyNode pre) {
        this.pre = pre;
    }
    
    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
