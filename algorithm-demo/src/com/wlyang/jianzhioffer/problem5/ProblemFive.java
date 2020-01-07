package com.wlyang.jianzhioffer.problem5;

import java.util.Stack;

/**
 * @Description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author: wlyang
 * @since: 2020-1-7
 */
public class ProblemFive {
    public static void main(String[] args) {
        //"PSH1","PSH2","PSH3","POP","POP","PSH4","POP","PSH5","POP","POP"
        Solution s = new Solution();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.push(4);
        System.out.println(s.pop());
        s.push(5);
        System.out.println(s.pop());
        System.out.println(s.pop());


    }
}

class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
