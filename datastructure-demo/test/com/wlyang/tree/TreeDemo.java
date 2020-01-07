package com.wlyang.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @author: wlyang
 * @since: 2020-1-3
 */
public class TreeDemo {
    public static void main(String[] args) {

    }

    /**
     * 后序遍历 非递归
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();


        List<Integer> result = new ArrayList<>();
        while (root != null) {
            nodeStack.push(root);
            root = root.getLeft();
        }
        //
        while (!nodeStack.empty()) {
            TreeNode temp = nodeStack.peek();
            if (temp.getRight() != null) {
                nodeStack.push(temp.getRight());
                while (temp.getRight().getLeft() != null) {
                    nodeStack.push(temp.getRight().getLeft());
                }

                if (temp.getRight().getRight() == null) {
                    System.out.println(temp.getRight());
                    nodeStack.pop();
                    System.out.println(temp.toString());
                    nodeStack.pop();
                }
            } else {
                result.add(temp.getVal());
                nodeStack.pop();
            }
        }
        return result;
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
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

