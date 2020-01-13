package com.wlyang.jianzhioffer.problem19;

import java.util.ArrayList;

/**
 * @Description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * <p>
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * @author: wlyang
 * @since: 2020-1-13
 */
public class ProblemNineteen {
    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ArrayList<Integer> result = Solution.printMatrix(array);
        System.out.println(result);
    }
}

class Solution {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        //定义当前起点的坐标
        int rowBegin = 0;
        int colBegin = 0;
        //定义当前轮次的右下角坐标
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        for (int i = colBegin; i < colNum; i++) {
            result.add(matrix[rowBegin][i]);
        }
        for(int j = rowBegin+1; j<rowNum;j++){
            result.add(matrix[j][colNum-1]);
        }
        for(int k = colBegin-1;k>=colBegin;k--){
            result.add(matrix[rowNum-1][k]);
        }
        for(int h = rowNum-1;h>=rowBegin;h--){
            result.add(matrix[h][colBegin]);
        }
        //result.add(matrix)
        return result;
    }
}
