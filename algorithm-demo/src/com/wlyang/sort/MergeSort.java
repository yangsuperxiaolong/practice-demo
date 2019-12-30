package com.wlyang.sort;

import java.util.Arrays;

/**
 * @Description: 归并排序
 * @author: wlyang
 * @since: 2019-12-30
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{7,2,4,5,9,3,8,6,1};
        mergeSort(array);
    }
    public static int[] mergeSort(int[] orginalArray){
        //先将元素数组切分
        while (orginalArray.length/2>0) {
            int point = orginalArray.length / 2;
            int[] leftArray = Arrays.copyOfRange(orginalArray, 0, point);
            int[] rightArray = Arrays.copyOfRange(orginalArray, point, orginalArray.length);
            mergeSort(leftArray);
            mergeSort(rightArray);
            int[] result = new int[leftArray.length+rightArray.length];
            int leftBegin = 0;
            int rightBegin = 0;
            for(int i = 0;i<leftArray.length||i<rightArray.length;i++){
                if(leftArray[leftBegin]>rightArray[rightBegin]){
                    //当左边的值大于右边时候，就把右边的值放到结果数组
                    result[i] = rightArray[rightBegin];
                    rightBegin++;
                }else{
                    result[i] = leftArray[leftBegin];
                    leftBegin++;
                }
            }
            if(leftBegin<leftArray.length-1){
                Arrays.
            }
            if(rightBegin<rightArray.length-1){

            }
        }
        //合并
        return null;
    }
}
