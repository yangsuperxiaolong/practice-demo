package com.wlyang.tree.binarysorttree;

/**
 * @Description: 排序二叉树
 * @author: wlyang
 * @since: 2020-5-8
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree();
        int[] array = {7,2,1,5,6,5};
        for(int i = 0 ; i < array.length; i++){
            binarySortTree.add(new TreeNode(array[i]));
        }
        binarySortTree.infix();
    }
}

class BinarySortTree{
    private TreeNode root;

    public void add(TreeNode node){
        if(root==null){
            root = node;
        }else {
            root.add(node);
        }
    }

    public void infix(){
        if(root==null){
            System.out.println("树为空");
        }else {
            root.infix();
        }
    }

}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value){
        this.value = value;
    }

    //增加节点
    public void add(TreeNode node){
        if(node.value<value){
            if(left == null){
                left = node;
            }else {
                left.add(node);
            }
        }else {
            if(right == null){
                right = node;
            }else {
                right.add(node);
            }
        }
    }

    //中序遍历

    public void infix(){
        if(left!=null){
            left.infix();
        }
        System.out.println(value);
        if(right!=null){
            right.infix();
        }
    }
}
