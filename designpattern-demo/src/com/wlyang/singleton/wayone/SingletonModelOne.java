package com.wlyang.singleton.wayone;

/**
 * @Description: 单例模式创建方式1
 * @author: wlyang
 * @since: 2019-12-18
 */
public class SingletonModelOne implements Runnable {
    /**
     * 创建单例模式需要考虑的因素
     * 1.即时- 懒 加载
     * 2.线程是否安全
     * 3.效率
     */
    public static void main(String[] args) {
        SingletonModelOne s = new SingletonModelOne();
        new Thread(s).start();
    }

    @Override
    public void run() {
        for(int i = 0 ;i<100;i++){
            Singleton s = Singleton.getInstance();
            System.out.println(s.hashCode());
        }
    }
}


class Singleton{
    //先将构造器私有化，防止外部创建对象
    private Singleton(){}

    private static final Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }

}
