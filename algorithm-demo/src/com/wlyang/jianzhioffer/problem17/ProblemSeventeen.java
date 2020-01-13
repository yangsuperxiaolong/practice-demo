package com.wlyang.jianzhioffer.problem17;


/**
 * @Description:
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 * @author: wlyang
 * @since: 2020-1-13
 */
public class ProblemSeventeen {
}

class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        return false;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}