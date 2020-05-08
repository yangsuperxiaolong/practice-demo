package com.wlyang.jianzhioffer.problem21;


import java.util.Stack;

/**
 * @Description:
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * @author: wlyang
 * @since: 2020-1-14
 */
public class ProblemTwentyOne {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{4,5,3,2,1};
        int[] b1 = new int[]{1,5,4,3,2};
        System.out.println(Solution.IsPopOrder(a,b));
    }
}

class Solution {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int j = 0 ;j< pushA.length;j++){
            stack.push(pushA[j]);
            while (i<popA.length && popA[i] == stack.peek()){
                //如果相等就是需要弹出的。
                stack.pop();
                i++;
                if(stack.isEmpty()){
                    break;
                }
            }
        }
        return stack.isEmpty();
    }
}