package com.wlyang.sort;

/**
 * @Description: 数组工具
 * @author: wlyang
 * @since: 2019-12-30
 */
public class ArrayUtil {
    /**
     * 数组打印
     *
     * @param array
     */
    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            System.out.print(array[i]);
            if (i == array.length-1){
                System.out.println("]");
            }else {
                System.out.print(",");
            }
        }
    }
}
