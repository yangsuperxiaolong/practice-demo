package com.wlyang.stack;

import com.wlyang.linkedlist.Node;

/**
 * @Description: 用单链表实现栈
 * @author: wlyang
 * @since: 2019-12-11
 */
public class StackLink {
    //栈底指针
    private Node bottom;
    //栈顶指针
    private Node top;

    //初始化一个栈
    public StackLink() {
        bottom = new Node(-1, "");
        top = bottom;
    }

    //判断栈空
    public Boolean isEmpty() {
        if (bottom == top) {
            return true;
        }
        return false;
    }

    //压栈
    public void push(Node node){
        Node temp = bottom;
        while (temp!=top){
            temp = temp.getNext();
        }
        temp.setNext(node);
        top=node;
    }
    //出栈
    public Node pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }
        Node temp = bottom;
        while (temp.getNext()!=top){
            temp = temp.getNext();
        }
        top = temp;
        return temp.getNext();
    }

}
