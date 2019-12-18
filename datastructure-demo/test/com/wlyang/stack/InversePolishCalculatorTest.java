package com.wlyang.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author: wlyang
 * @since: 2019-12-17
 */
public class InversePolishCalculatorTest {
    public static void main(String[] args) {
        InversePolishCalculator a = new InversePolishCalculator();
        List<String> suffixExpression = new ArrayList<>();
        //将中缀表达式转成 后缀表达式
        List<String> infixExpression = InversePolishCalculator.getInfixExpression("28 + ( 16 - 2 )");
        //1+(2-3)*4+4/2
        List<String> infixExpression2 = InversePolishCalculator.getInfixExpression("1 + ( ( 2 + 3 ) * 4 ) - 5");
        suffixExpression = InversePolishCalculator.infixToSuffix(infixExpression2);
        System.out.println(a.calculate(suffixExpression));
    }
}
