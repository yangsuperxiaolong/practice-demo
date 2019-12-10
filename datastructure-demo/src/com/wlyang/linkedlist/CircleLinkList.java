package com.wlyang.linkedlist;

/**
 * @Description: 循环链表
 * @author: wlyang
 * @since: 2019-12-10
 */
public class CircleLinkList {
    private DoublyNode head;

    public CircleLinkList() {
        head = new DoublyNode(-1, "");
    }

    /**
     * 实现循环链表节点添加
     */
    public void add(DoublyNode node) {
        if(head.getNext()==null){
            //如果链表为空
            head.setNext(node);
            node.setNext(node);
            node.setPre(node);
        }else {
            //找到尾节点
            DoublyNode temp=head.getNext();
            while (temp.getNext()!=head.getNext()){
                temp = temp.getNext();
            }
            //在尾节点和第一个节点插入 节点
            temp.setNext(node);
            node.setNext(head.getNext());
            node.setPre(temp);
            head.getNext().setPre(node);
        }
    }

    /**
     * 实现循环链表节点遍历
     */
    public void show() {
        if(head.getNext()==null){
            throw new RuntimeException("链表为空");
        }
        DoublyNode temp=head.getNext();
        while (temp.getNext() !=head.getNext()) {
            System.out.println(temp);
            temp = temp.getNext();
        }
        System.out.println(temp);
    }
    
    /*
     * description:  环形链表长度<br>
     * 
     * @param 
     * @return int
     */ 
    public int size() {
        int size = 0;
        if(head.getNext()==null){
            return size;
        }
        DoublyNode temp=head.getNext();
        while (temp.getNext() !=head.getNext()) {
            size++;
            temp = temp.getNext();
        }
        size++;
        return size;
    }

    /**
     * description: 根据节点ID删除环形链表节点 <br>
     *
     * @param id
     * @return void
     */
    public void deleteById(int id) {
        if(head.getNext()==null){
            throw new RuntimeException("链表为空");
        }
        DoublyNode temp=head.getNext();
        while (temp.getNext() !=head.getNext()) {
            if(temp.getId() == id){

            }
        }
        System.out.println(temp);
    }
}
