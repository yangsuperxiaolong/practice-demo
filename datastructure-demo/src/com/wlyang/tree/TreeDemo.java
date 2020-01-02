package com.wlyang.tree;

/**
 * @Description:
 * @author: wlyang
 * @since: 2020-1-2
 */
public class TreeDemo {
}

class Tree{
    private TreeNode root;

    //前序遍历
    public void preOrder(TreeNode node){
        System.out.println();
        if(node.getLeft()!=null){
            preOrder(node.getLeft());
        }
        if(node.getRight()!=null){
            preOrder(node.getRight());
        }
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
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}