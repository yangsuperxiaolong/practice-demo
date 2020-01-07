package com.wlyang.jianzhioffer.problem10;

/**
 * @Description:
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author: wlyang
 * @since: 2020-1-7
 */
public class ProblemTen {
    public static void main(String[] args) {
        System.out.println(Solution.RectCover(3));
    }
}
class Solution {
    public static int RectCover(int target) {
        //分治 - 动态规划
        //找出关系 f(n)  = f(n-1)+f(n-2)*2
        //可以用递归，也可以用动态规划
        int[] temp = new int[target];
        if(target==0){
            return 0;
        }else if(target == 1){
            return 1;
        }else if(target == 2){
            return 2;
        }
        temp[0] = 1;
        temp[1] = 2;

        /**
         * 动态规划，本质就是分解
         *
         * 比如如果跳到第4级阶梯，只有两种路径，一种从第2级阶梯跳两步上来，或者从第3级阶梯跳一步上来
         * 用一个数组保存跳到某级阶梯的跳法数
         */
        if(target>1) {
            for (int i = 2; i < target; i++) {
                for(int j = 0;j<i;j++) {
                    temp[i] += temp[j] ;
                }
                temp[i]=temp[i]+1;
            }
        }
        return temp[target-1];
    }
}
