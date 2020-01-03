package com.wlyang.tree;

import java.util.Stack;

/**
 * description: TreeDemo <br>
 * date: 20-1-2 下午9:36 <br>
 * author: wlyang <br>
 * version: 1.0 <br>
 */
public class TreeDemo {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1,"龙大爷");
        TreeNode node2 = new TreeNode(2,"龙大爷1");
        TreeNode node3 = new TreeNode(3,"龙大爷2");
        TreeNode node4 = new TreeNode(4,"龙大爷2");
        TreeNode node5 = new TreeNode(5,"龙大爷2");
        node3.setLeft(node4);
        node3.setRight(node5);
        node1.setLeft(node3);
        node1.setRight(node2);
        Tree s = new Tree(node1);
        s.postOrder2();
    }
}

class Tree{
    private  TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    //后序遍历
    public void postOrder(){
        this.root.postOrder();
    }
    /**
     * description: 后序遍历非递归 <br>
     *
     * @param
     * @return void
     */
    public void postOrder2(){
        Stack<TreeNode> nodeStack = new Stack<>();
        while (root!=null){
            nodeStack.push(root);
            root = root.getLeft();
        }
        //
        while (!nodeStack.empty()){
            TreeNode temp = nodeStack.pop();
            if(temp.getRight()!=null){
                nodeStack.push(temp.getRight());
                while(temp.getRight().getLeft()!=null){
                    nodeStack.push(temp.getRight().getLeft());
                }
                System.out.println(temp.toString());
            }else{
                System.out.println(temp.toString());
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}

class TreeNode{
    private int id;
    private String name;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void  postOrder(){
        if(left!=null){
            left.postOrder();
        }
        if(right!=null){
            right.postOrder();
        }
        System.out.println(this.toString());
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

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }{

    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
