package com.wlyang.linkedlist;

import com.wlyang.stack.StackLink;

/**
 * @Description:
 * @author: wlyang
 * @since: 2019-12-11
 */
public class StackLinkTest {
    public static void main(String[] args) {
        StackLink link = new StackLink();
        link.push(new Node(3,"学生3"));
        link.push(new Node(1,"学生1"));
        link.push(new Node(2,"学生2"));

        System.out.println(link.pop());
        System.out.println(link.pop());
        System.out.println(link.pop());
        System.out.println(link.pop());
    }
}
