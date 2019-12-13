package com.wlyang.dp;

import java.util.Random;

/**
 * @Description: 最短路径
 * @author: wlyang
 * @since: 2019-12-13
 */
public class DpShortestPath {
    public static void main(String[] args) {
        //创建一个棋盘
        int m = 3;
        int n = 3;
        int[][] checkerboard = new int[m][n];
        //初始化棋盘
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                checkerboard[i][j] = new Random().nextInt(10)+1;
            }
        }
        //棋盘展示
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d\t",checkerboard[i][j]);
                if(j==n-1){
                    //换行
                    System.out.println();
                }
            }
        }

        System.out.println("最短路径长度"+getShortestPath(checkerboard));
    }

    public static int getShortestPath(int[][] checkerboard) {
        //计算源棋盘长宽
        int m = checkerboard.length;
        int n = checkerboard[0].length;
        //用一个二维数组存最短路径的值
        int[][] temp = new int[m][n];

        //可以知道 temp[m-1][n-j]表示从(0,0)->(m-1,n-1)的最短路径值

        //分析关系
        //要想到达(m-1,n-1),那么达到的前一个坐标点只能是(m-1,n-2)或者(m-2,n-1)
        //所以 到达(m-1,n-1)的最短路径值是mix(temp[m-1][n-2]+checkerboard[m-1][n-j],temp(m-2,n-1)+checkerboard(m-2,n-1))

        //然后先找到初始循环节点
        temp[0][1] = checkerboard[0][0];
        temp[1][0] = checkerboard[0][0];

        // 初始化
        for(int i = 0; i < m-1; i++){
            temp[i+1][0] = temp[i][0]+checkerboard[i][0];
        }
        for(int i = 0; i < n-1; i++){
            temp[0][i+1] = temp[0][i]+checkerboard[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                temp[i][j] = Math.min(temp[i][j - 1] + checkerboard[i][j - 1], temp[i - 1][j] + checkerboard[i - 1][j]);
                //TODO 如何打印 经过的路径坐标
            }
        }
        return temp[m - 1][n - 1];
    }
}
