package com.wlyang.jianzhioffer.problem2;

/**
 * @Description:请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author: wlyang
 * @since: 2020-1-6
 */
public class ProblemTwo {
    public static void main(String[] args) {
        StringBuffer str =  new StringBuffer("We Are Happy");
        System.out.println(Solution.replaceSpace(str));
    }
}

class Solution {
    public static String replaceSpace(StringBuffer str) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (' ' == str.charAt(i)){
                result.append("%20");
            }else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}