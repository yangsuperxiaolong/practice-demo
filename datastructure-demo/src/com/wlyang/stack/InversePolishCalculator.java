package com.wlyang.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 逆波兰计算器
 * @author: wlyang
 * @since: 2019-12-17
 */
public class InversePolishCalculator {
    /**
     * 分析：要计算一个中缀表达式如 1+(2+3)*4+(7-5)/2
     * 1. 先把中缀表达式的数字和符号用ArrayList存起来
     *
     * 2. 将中缀表达式List 转成 后缀表达式list
     *
     * 3. 计算后缀表达式的结果
     */

    public int calculate(List<String> suffixExpression) {
        StackArray<Integer> numStack = new StackArray<>(100);
        for (String temp:suffixExpression) {
            if (temp.matches("\\d+")) {
                //如果得到的值是num,那么直接入数栈
                numStack.push(Integer.parseInt(temp));
            } else{
                //如果是运算符
                int y = numStack.pop();
                int x = numStack.pop();
                int result = calcu(x,y,temp);
                numStack.push(result);
            }
        }
        return numStack.pop();
    }

    //求两个数的计算结果
    private static int calcu(int x, int y, String operator) {
        switch (operator) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
            default:
                return 0;
        }
    }

    /**
     * 把中缀表达式的数字和符号用ArrayList存起来
     * @param expression
     * @return
     */
    public static List<String> getInfixExpression(String expression) {
        String[] expressionArray = expression.split(" ");
        List result = new ArrayList(Arrays.asList(expressionArray));
        return result;
    }

    /**
     * 将中缀表达式List 转成 后缀表达式list
     * 思路：
     * 1.定义一个符号栈 和 一个存后缀表达式的集合
     * 2.循环遍历中缀表达式
     *   2.1 如果遇到的是数字 直接 加入后缀表达式集合
     *   2.2 如果遇到的是 左括号 直接压入符号栈中
     *   2.3 如果遇到的是 右括号 那么弹出符号栈中的元素，将元素加入后缀表达式，直到遇到左括号为止-把左括号弹出丢弃
     *   2.4 如果是运算符
     *      2.4.1 如果当前符号栈是空，或者是左括号：
     *            则直接将当前运算符加入后缀表达式集合
     *      2.4.2 否则比较符号优先级-如果当前运算符比符号栈顶运算符优先级更高
     *            则优先加入后缀表达式的集合 - 直接压入符号栈
     *      2.4.3 否则比较符号优先级-如果当前运算符优先级符号栈顶运算符优先级一样或更低
     *            则需要后续加入后缀表达式的集合 -先将符号栈顶的运算符弹出加入后缀表达式，然后将当前运算符压入符号栈
     *      （比较符号栈举例  1 + 2 * 3 ->  1 2 3 * -  *比-优先级高，说明*直接加入后缀表达式，
     *       如果是 1 * 2 + 3 -> 1 2 3 * +  先要把*弹出，先加入后缀表达式，然后把+压入符号栈
     *
     * @param infixExpression
     * @return
     */
    public static List<String> infixToSuffix(List<String> infixExpression){
        StackArray<String> operatorStack = new StackArray<>(100);
        List<String> suffixExpression = new ArrayList<>();
        for(String temp : infixExpression){
            if(temp.matches("\\d+")){
                suffixExpression.add(temp);
            }else if(temp.equals("(")){
                operatorStack.push(temp);
            }else if(temp.equals(")")){
                while(!operatorStack.peek().equals("(")){
                    suffixExpression.add(operatorStack.pop());
                }
                operatorStack.pop();
            }else {
                //如果是运算符
                if(operatorStack.isEmpty() || operatorStack.peek().equals("(")){
                    operatorStack.push(temp);
                }else if(getPriority(temp)>getPriority(operatorStack.peek())){//比较当前运算符和栈顶运算符优先级
                    operatorStack.push(temp);
                }else {
                    suffixExpression.add(operatorStack.pop());
                    operatorStack.push(temp);
                }
            }
        }

        //将栈元素依次弹出
        while(!operatorStack.isEmpty()){
            suffixExpression.add(operatorStack.pop());
        }
        return suffixExpression;
    }

    //获取符号优先级
    private static int getPriority(String operator){
        if("+".equals(operator)){
            return 1;
        }else if("-".equals(operator)){
            return 1;
        }else if("*".equals(operator)){
            return 2;
        }else if("/".equals(operator)){
            return 2;
        }else {
            throw new RuntimeException("运算符有误");
        }
    }

}
