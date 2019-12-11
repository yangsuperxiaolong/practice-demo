package com.wlyang.hash;

import com.wlyang.linkedlist.LinkList;
import com.wlyang.linkedlist.Node;

/**
 * @Description: 使用数组加链表实现hash表
 * @author: wlyang
 * @since: 2019-12-11
 */
public class HashTab {
    //一个链表数组
    private LinkList[] linkLists;

    public HashTab(){
        linkLists = new LinkList[]{new LinkList(),new LinkList(),new LinkList(),new LinkList(),new LinkList(),new LinkList(),new LinkList(),new LinkList(),new LinkList(),new LinkList()};
    }


    //hash函数
    private int hash(int k){
        return k%10;
    }

    //插入
    public void add(Node node){
        //插入哪根单链表
        int position = hash(node.getId());
        linkLists[position].add(node);
    }
    //查找
    public Node search(int id){
        int position = hash(id);
        return linkLists[position].search(id);
    }


}
