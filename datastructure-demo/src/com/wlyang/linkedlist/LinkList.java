package com.wlyang.linkedlist;

public class LinkList {
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
     * description: 获取链表倒数第K个节点 <br>
     *
     * @return Node 节点
     */
    public Node getBackwords(int k) {
        if (isEmpty()) {
            throw new RuntimeException("链表为空，没有节点");
        }
        if (k <= 0) {
            throw new RuntimeException("k不能小于等于0");
        }
        if (k > size()) {
            throw new RuntimeException("k不能大于链表长度");
        }
        Node temp = head.getNext();
        //temp初始值已经指向链表的第一个节点
        //倒数第size个，即链表第1个元素，倒数第一个，即链表第size个元素
        //临界点最好用实际值算一下。
        for (int i = 0; i < size() - k; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * description: 判断链表是否为空 <br>
     *
     * @return int 节点个数
     */
    public Boolean isEmpty() {
        return head.getNext() == null ? true : false;
    }

    /**
     * description: 单链表反转方式1 - 头节点插入法 <br>
     *
     * @return Node 反转后链表的头节点
     */
    public void reverse() {
        //判断链表是否为空
        if (isEmpty()) {
            throw new RuntimeException("单链表为空，无法反转");
        }
        Node p = head.getNext();
        Node q = null;
        //如果链表只有一个元素，那就不需要反转
        if (p.getNext() == null) {
            return;
        }
        //借助一个新的头节点插入
        Node newHead = new Node(-1, "");
        //p表示待插入节点，q用来表示待插入节点的后一个节点
        //q节点的意义：因为q插入后，q.next内容就丢了，所以需要一个变量保存
        while (p != null) {
            q = p.getNext();
            p.setNext(newHead.getNext());
            newHead.setNext(p);
            p = q;
        }
        //将当前链表头指向反转成功的链表
        head.setNext(newHead.getNext());
    }

    /**
     * description: 单链表反转-方式2 尾节点插入<br>
     * 缺点: 需要预先找到尾节点
     *
     * @return Node 反转后链表的头节点
     */
    public void reverse1() {
        //判断链表是否为空
        if (isEmpty()) {
            throw new RuntimeException("单链表为空，无法反转");
        }
        Node p = head.getNext();
        Node q = null;
        //如果链表只有一个元素，那就不需要反转
        if (p.getNext() == null) {
            return;
        }
        Node end = head;
        //找到尾节点
        while (end.getNext() != null) {
            end = end.getNext();
        }
        while (p != end) {
            head.setNext(p.getNext());
            q = p.getNext();
            p.setNext(end.getNext());
            end.setNext(p);
            p = q;
        }
    }


    /**
     * description: 单链表反转-方式2 就地反转<br>
     * 缺点: 需要预先找到尾节点
     *
     * @return Node 反转后链表的头节点
     */
    public void reverse2() {
        //判断链表是否为空
        if (isEmpty()) {
            throw new RuntimeException("单链表为空，无法反转");
        }
        Node p = head.getNext();
        Node q = p.getNext();
        //如果链表只有一个元素，那就不需要反转
        if (p.getNext() == null) {
            return;
        }
        while (q != null) {
            p.setNext(q.getNext());
            q.setNext(head.getNext());
            head.setNext(q);
            q = p.getNext();
        }
    }

    /**
     * description: 获取链表有效节点个数 <br>
     *
     * @return int 节点个数
     */
    public int size() {
        int size = 0;

        Node temp = head.getNext();
        //链表为空
        while (null != temp) {
            temp = temp.getNext();
            size++;
        }
        return size;
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

    /**
     * description: 根据id查找链表节点 <br>
     *
     * @param id
     * @return Node
     */
    public Node search(int id) {
        Node temp = head.getNext();
        if (temp == null) {
            System.out.println("链表为空");
            throw new RuntimeException("节点不存在");
        }
        while (temp != null) {
            if(temp.getId() == id){
                return temp;
            }
            temp = temp.getNext();
        }
        throw new RuntimeException("节点不存在");
    }
}
