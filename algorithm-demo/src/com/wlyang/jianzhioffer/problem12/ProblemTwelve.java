package com.wlyang.jianzhioffer.problem12;

/**
 * @Description:
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * @author: wlyang
 * @since: 2020-1-8
 */
public class ProblemTwelve {
    public static void main(String[] args) {
        System.out.println(Solution.Power(2,-2));
    }
}
class Solution {
    public static double Power(double base, int exponent) {
        double result = 1;
        if(exponent ==0){
            return result;
        }else if(exponent>0) {
            for(int i = 0;i<exponent;i++){
                result = result * base;
            }
            return result;
        }else {
            for(int i = 0;i<-exponent;i++){
                result = result * base;
            }
            return 1/result;
        }
    }
}
