package com.wlyang.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 使用栈对表达式求值测试
 * @author: wlyang
 * @since: 2019-12-13
 */
public class ExpressionEvaluationTest {
    private static List<Character> operatorList = new ArrayList();

    public static void main(String[] args) {
        operatorList.add('+');
        operatorList.add('-');
        operatorList.add('*');
        operatorList.add('/');

        //定义一个待求值的表达式
        String expression = "3*5+7+1+2";
        System.out.println("计算结果为：" + calculate(expression));

    }

    private static int calculate(String expression) {
        //1.创建两个栈，一个栈存放数值，一个栈存放操作符
        StackArray<Integer> numStack = new StackArray(100);
        StackArray<Character> operatorStack = new StackArray(100);
        /**
         * 求值思路：
         * 【1】遍历表达式
         * 1.如果得到的值是num,那么直接入数栈，
         * 2.如果得到的值是符号
         *     2.1 如果当前符号栈为空，那么直接入符号栈
         *     2.2 如果当前符号栈不为空，比较符号栈栈顶位置的符号和当前符号的优先级
         *         3.1 如果当前符号的优先级比栈顶符号优先级高，则 弹出数栈和当前符号的后一个数字，用当前符号运算，得到结果压入数栈
         *         3.2 如果优先级一样，甚至更低，则将当前符号压入栈。
         * 【2】
         *  弹出数栈和符号栈，获取结果
         *
         *
         */
        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                //如果得到的值是num,那么直接入数栈
                numStack.push(Character.digit(expression.charAt(i),10));
            } else if (operatorList.contains(expression.charAt(i))) {
                //如果得到的值是符号
                if (operatorStack.isEmpty()) {
                    //如果当前符号栈为空，那么直接入符号栈
                    operatorStack.push(expression.charAt(i));
                } else {//如果当前符号栈不为空，比较符号栈栈顶位置的符号和当前符号的优先级
                    char topChar = operatorStack.pop();
                    if (isHighPriority(expression.charAt(i), topChar)) {
                        //如果当前符号的优先级比栈顶符号优先级高
                        //则 弹出数栈和当前符号的后一个数字，用当前符号运算，得到结果压入数栈
                        int x = numStack.pop();
                        int y = Character.digit(expression.charAt(i+1),10);
                        numStack.push(calcu(x, y, expression.charAt(i)));
                        operatorStack.push(topChar);
                        i++;
                    } else if(isHighPriority(topChar, expression.charAt(i))){
                        //如果当前符号的优先级比栈顶符号优先级低
                        //则 弹出数栈和当前符号的后一个数字，用当前符号运算，得到结果压入数栈
                        int y= numStack.pop();
                        int x =numStack.pop();
                        numStack.push(calcu(x, y, topChar));
                        operatorStack.push(expression.charAt(i));
                    }else {
                        operatorStack.push(topChar);
                        operatorStack.push(expression.charAt(i));
                    }
                }
            }
        }

        //结算结果
        while (!operatorStack.isEmpty()) {
            int y = numStack.pop();
            int x = numStack.pop();
            char operator = operatorStack.pop();
            numStack.push(calcu(x, y, operator));
        }
        return numStack.pop();
    }

    //判断两个符号的优先级
    private static Boolean isHighPriority(char highPriority, char lowPriority) {

        if (!operatorList.contains(highPriority) || !operatorList.contains(lowPriority)) {
            throw new RuntimeException("运算符有误");
        }
        if ((('*' == highPriority) || ('/' == highPriority)) && ((('+' == lowPriority)) || (('-' == lowPriority)))) {
            return true;
        }
        return false;
    }

    //求两个数的计算结果
    private static int calcu(int x, int y, char operator) {
        switch (operator) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x - y;
            default:
                return 0;
        }
    }
}
