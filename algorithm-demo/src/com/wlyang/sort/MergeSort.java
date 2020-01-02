package com.wlyang.sort;

import java.util.Arrays;

/**
 * @Description: 归并排序
 * @author: wlyang
 * @since: 2019-12-30
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{7, 2, 4, 5, 9, 3, 8, 6,1};
//        int[] a = new int[]{1,2,3,4,5,6};
//        int[] b = new int[]{7,8,9};
//        System.arraycopy(b,0,a,2,2);
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
        System.out.print("结果:");
        System.out.println(Arrays.toString(array));
    }


    public static void mergeSort(int[] array, int left, int right, int[] temp) {
        //先将元素数组切分
        int mid = (left + right) / 2;
        System.out.println("当前：left="+left+",right="+right+",mid="+mid);
        if (left < right) {
            //拆分左边数组
            System.out.println("开始拆分左侧数组");
            mergeSort(array, left, mid, temp);
            //拆分右边数组
            System.out.println("开始拆分右侧数组");
            mergeSort(array, mid+1, right, temp);
            //合并数组
            merge(array, left, right, temp);
        }
    }

    public static void merge(int[] array, int left, int right, int[] temp) {
        int mid = (left + right) / 2;
        System.out.println("merge合并：当前：left="+left+",right="+right+",mid="+mid);
        //指向左侧数组起始位置
        int i = left;
        //指向右侧数组起始位置
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (array[i] > array[j]) {//如果右侧元素大于左侧元素
                temp[k] = array[j];
                j++;
            } else {
                temp[k] = array[i];
                i++;
            }
            k++;
        }

        //填充
        while (i <= mid) {
            temp[k] = array[i];
            i++;
            k++;
        }
        //右侧数组来填充
        while (j <= right) {
            temp[k] = array[j];
            j++;
            k++;
        }

        int t = 0;
        int tempLeft = left;
        while(tempLeft<=right){
            array[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
        System.out.println("temp="+Arrays.toString(temp));
        System.out.println("array="+Arrays.toString(array));

    }
}

