package com.wlyang.jianzhioffer.problem13;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author: wlyang
 * @since: 2020-1-8
 */
public class ProblemThirteen {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        Solution.reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
}

class Solution {
    public static void reOrderArray(int[] array) {
        //方法一：定义额外数组赋值
//        int[] tempArray = new int[array.length];
//        int oddNum = 0;
//        int evenNum = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] % 2 == 0) {
//                evenNum++;
//            }
//        }
//        oddNum = array.length-evenNum;

        //方法2：定义两个栈
        //奇数栈
        Stack<Integer> oddStack = new Stack<>();
        //偶数栈
        Stack<Integer> evenStack = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenStack.push(array[i]);
            }else {
                oddStack.push(array[i]);
            }
        }

        //奇数坐标范围  0  --- oddStack.size()-1
        //偶数坐标范围  oddStack.size() - array.length-1

        for(int  i = array.length-1; i>= oddStack.size();i--){
            //偶数倒叙入栈
            array[i] = evenStack.pop();
        }
        for (int i = oddStack.size()-1; i >= 0; i--) {
            array[i] =  oddStack.pop();
        }
    }
}
