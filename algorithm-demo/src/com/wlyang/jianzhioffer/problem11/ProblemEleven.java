package com.wlyang.jianzhioffer.problem11;

/**
 * @Description: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author: wlyang
 * @since: 2020-1-8
 */
public class ProblemEleven {
    public static void main(String[] args) {
        //23是10111
        System.out.println(Solution.NumberOf1(-23));
    }
}
class Solution {
    public static int NumberOf1(int n) {
        //被除数
        int dividend = n;
        //除数
        int divisor = 2;
        //计数器
        int countOne = 0;
        while (dividend>=1){
            if(dividend%divisor==1){
                countOne++;
            }
            dividend = dividend/divisor;
        }
        return countOne;
    }
}
/**
 * 知识点
 * 1. 原码
 * 原码就是符号位加上真值的绝对值, 即用第一位表示符号, 其余位表示值. 比如如果是8位二进制:
 *
 * [+1]原 = 0000 0001
 *
 * [-1]原 = 1000 0001
 *
 * 第一位是符号位. 因为第一位是符号位, 所以8位二进制数的取值范围就是:
 *
 * [1111 1111 , 0111 1111]
 *
 * 即
 *
 * [-127 , 127]
 *
 * 原码是人脑最容易理解和计算的表示方式.
 *
 * 2. 反码
 * 反码的表示方法是:
 *
 * 正数的反码是其本身
 *
 * 负数的反码是在其原码的基础上, 符号位不变，其余各个位取反.
 *
 * [+1] = [00000001]原 = [00000001]反
 *
 * [-1] = [10000001]原 = [11111110]反
 *
 * 可见如果一个反码表示的是负数, 人脑无法直观的看出来它的数值. 通常要将其转换成原码再计算.
 *
 * 3. 补码
 * 补码的表示方法是:
 *
 * 正数的补码就是其本身
 *
 * 负数的补码是在其原码的基础上, 符号位不变, 其余各位取反, 最后+1. (即在反码的基础上+1)
 *
 * [+1] = [00000001]原 = [00000001]反 = [00000001]补
 *
 * [-1] = [10000001]原 = [11111110]反 = [11111111]补
 */
