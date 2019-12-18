package com.wlyang.singleton;

/**
 * @Description: 单例模式创建方式1
 * @author: wlyang
 * @since: 2019-12-18
 */
public class SingletonModelOne {
    /**
     * 创建单例模式需要考虑的因素
     * 1.即时- 懒 加载
     * 2.线程是否安全
     * 3.效率
     */
    private SingletonModelOne(){

    }


    public static SingletonModelOne getInstance(){
        return new SingletonModelOne();
    }
}
