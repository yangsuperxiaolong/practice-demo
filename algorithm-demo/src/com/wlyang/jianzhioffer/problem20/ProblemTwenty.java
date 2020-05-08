package com.wlyang.jianzhioffer.problem20;

import java.util.Stack;

/**
 * @Description:
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @author: wlyang
 * @since: 2020-1-14
 */
public class ProblemTwenty {
    public static void main(String[] args) {

    }
}

class Solution {
    private Stack<Integer> stack;

    public Solution(Stack<Integer> stack) {
        this.stack = stack;
    }
    public void push(int node) {
        stack.push(node);
    }
    public void pop() {
        stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int min() {
        Stack<Integer> a = new Stack<>();
        return 0;
    }
}