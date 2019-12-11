package com.wlyang.linkedlist;

/**
 * @Description: 用循环链表实现约瑟夫问题
 * @author: wlyang
 * @since: 2019-12-11
 */
public class JosephusTest {
    public static void main(String[] args) {
        CircleLinkList circleLinkList = new CircleLinkList();
        //初始状态
        for (int i = 1; i <= 41; i++) {
            Node node = new Node(i,"编号为"+i+"的人");
            circleLinkList.add(node);
        }

        Node temp = circleLinkList.getFirst();
        while (temp.getNext()!=temp){
            temp= temp.getNext().getNext();
            circleLinkList.delete(temp.getId());
            System.out.println("删除编号为"+temp.getId()+"的人");
            temp = temp.getNext();

        }
        System.out.println("删除编号为"+temp.getId()+"的人");
    }
}
