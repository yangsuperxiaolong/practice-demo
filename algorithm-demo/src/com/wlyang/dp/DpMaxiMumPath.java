package com.wlyang.dp;

/**
 * @Description: 动态规划算法-求[0,0]-[i,j]位置一共有多少种走法
 * @author: wlyang
 * @since: 2019-12-12
 */
public class DpMaxiMumPath {
    private static int[][] checkerboard;

    public static void main(String[] args) {
        //m*n的棋盘
        int m = 100;
        int n = 100;
        checkerboard = new int[m][n];
        System.out.print("递归用时");
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        System.out.println(getMaxiMum(16, 16));
        endTime= System.currentTimeMillis();
        System.out.println(endTime-startTime+"ms");

        System.out.print("动态规划用时");
        startTime = System.currentTimeMillis();
        System.out.println(uniquePaths(17,17));
        endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime+"ms");

    }

    public static int getMaxiMum(int i, int j) {
        //判断i,j值是否合理
        if (i < 0 || j < 0 || i > checkerboard.length || j > checkerboard[0].length) {
            throw new RuntimeException("坐标位置不符合要求");
        }
        /**
         * 开始动态规划求值
         * 1.可以用 checkerboard[i][j]的值表示从坐标(0,0)->(i,j)最多有多少种走法
         *  checkerboard[i][j]
         *
         * 2.尝试将checkerboard[i][j]分解成小问题。
         *     由移动方式可以分析出，要到达(i,j)坐标点，前一个节点只能是(i,j-1)或者(i-1,j)
         *   所以可知： checkerboard[i][j] = checkerboard[i][j-1]+checkerboard[i-1][j]
         *
         * 3.找到初始值
         *  由第2步可知，要求解最大规模的解，先要 求较小规模的解，这有种类似于递归的思想
         *  所以必须找到最小规模的解，然后依次迭代，求上一规模的值。
         */

        //找初始值
        //从(0,0)->(0,0)没有走法
        checkerboard[0][0] = 0;
        checkerboard[0][1] = 1;
        checkerboard[1][0] = 1;

        if (i >= 0 && j == 0) {
            return 1;
        } else if ((i == 0) && (j >= 0)) {
            return 1;
        } else if (i == 0 && j == 0) {
            return 0;
        } else {
            checkerboard[i][j] = getMaxiMum(i, j - 1) + getMaxiMum(i - 1, j);
        }
        return checkerboard[i][j];
    }

    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] dp = new int[m][n]; //
        // 初始化
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        // 推导出 dp[m-1][n-1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
