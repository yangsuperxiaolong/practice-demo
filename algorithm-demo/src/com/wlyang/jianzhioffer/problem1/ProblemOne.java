package com.wlyang.jianzhioffer.problem1;

/**
 * @Description:在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author: wlyang
 * @since: 2020-1-6
 */
public class ProblemOne {
    public static void main(String[] args) {
        int[][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Solution.Find(7, array));
    }
}

class Solution {
    public static boolean Find(int target, int[][] array) {
        int rowSum = 0;
        int colSum = 0;
        rowSum = array.length;
        if (rowSum == 0) {
            return false;
        } else {
            colSum = array[0].length;
        }
        if (colSum == 0) {
            return false;
        }
        int maxCol = colSum;
        int maxRow = rowSum;
        for (int col = 0; col < colSum; col++) {
            if (target < array[0][col]) {
                maxCol = col;
            } else if (target == array[0][col]) {
                return true;
            }
        }
        for (int row = 0; row < rowSum; row++) {
            if (target < array[row][0]) {
                maxRow = row;
            } else if (target == array[row][0]) {
                return true;
            }
        }
        for (int i = 0;i<maxRow;i++){
            for(int j = 0;j<maxCol;j++){
                if(target == array[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
}
