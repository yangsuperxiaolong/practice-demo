package com.wlyang.jianzhioffer.problem8;

/**
 * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @author: wlyang
 * @since: 2020-1-7
 */
public class ProblemEight {
    public static void main(String[] args) {
        System.out.println(Solution.JumpFloor(1));
    }
}

class Solution {
    public static int JumpFloor(int target) {
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
                temp[i] = temp[i - 1] + temp[i - 2];
            }
        }
        return temp[target-1];
    }
}