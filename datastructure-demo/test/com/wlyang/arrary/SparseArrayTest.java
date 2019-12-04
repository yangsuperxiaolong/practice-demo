package com.wlyang.arrary;

/**
 * @Description:
 * @author: wlyang
 * @since: 2019-11-20
 */
public class SparseArrayTest {
    public static void main(String[] args) {
        int row = 10;
        int col = 12;
        int[][] array = new int[row][col];
        System.out.println(array.toString());

        //赋值
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==j){
                    array[i][j]=i+j;
                }
            }
        }
        System.out.println(array.toString());

        //计算二维数组有效值个数
        int num =0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(array[i][j]!=0){
                    num++;
                }
            }
        }

        int[][] sparseArray = new int[num+1][3];
        sparseArray[0][0]= row;
        sparseArray[0][1]= col;
        sparseArray[0][2]= num;
        int tempRow = 1;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(array[i][j]!=0){
                    sparseArray[tempRow][0] = j;
                    sparseArray[tempRow][1] = i;
                    sparseArray[tempRow][2] = array[i][j];
                    tempRow++;
                }
            }
        }

        System.out.println(sparseArray);

        //将稀疏数组还原为二维数组
        int row2;
        int col2;
        row2 = sparseArray[0][0];
        col2 = sparseArray[0][1];
        int[][] resultArray = new int[row2][col2];
        for(int rowTemp=1;rowTemp<sparseArray.length;rowTemp++){
            resultArray[sparseArray[rowTemp][0]][sparseArray[rowTemp][1]] = sparseArray[rowTemp][2];
        }

        System.out.println(resultArray);



    }

    private static int[][] toSparseArray(int[][] array){

        return null;
    }
}
