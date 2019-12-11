package com.wlyang.stack;

import com.wlyang.hash.HashTab;
import com.wlyang.linkedlist.Node;

/**
 * @Description:
 * @author: wlyang
 * @since: 2019-12-11
 */
public class HashTabTest {
    public static void main(String[] args) {
        HashTab hashTab= new HashTab();
        hashTab.add(new Node(1,"天魁星呼保义宋江"));
        hashTab.add(new Node(2,"天罡星玉麒麟卢俊义"));
        hashTab.add(new Node(3,"天机星智多星吴用"));
        hashTab.add(new Node(4,"天闲星入云龙公孙胜"));
        hashTab.add(new Node(5,"天勇星大刀关胜"));
        hashTab.add(new Node(6,"天雄星豹子头林冲"));

        hashTab.add(new Node(104,"地劣星活闪婆王定六"));
        hashTab.add(new Node(105,"地健星险道神郁保四"));
        hashTab.add(new Node(106,"地耗星白日鼠白胜"));
        hashTab.add(new Node(107,"地贼星鼓上蚤时迁"));
        hashTab.add(new Node(108,"地狗星金毛犬段景住"));

        System.out.println(hashTab.search(104));
    }
}
