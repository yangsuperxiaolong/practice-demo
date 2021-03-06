package com.wlyang.singleton.waythree;

/**
 * @Description: 单例模式创建方式1
 * @author: wlyang
 * @since: 2019-12-18
 */
public class SingletonModelThree implements Runnable {
    /**
     * 创建单例模式需要考虑的因素
     * 1.即时- 懒 加载
     * 2.线程是否安全
     * 3.效率
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SingletonModelThree()).start();
        }
    }

    @Override
    public void run() {
        Singleton s = Singleton.getInstance();
        System.out.println(s.hashCode());
    }
}


class Singleton {
    //先将构造器私有化，防止外部创建对象
    private Singleton() {
    }

    private static Singleton instance = null;

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
            instance = new Singleton();
        }
        return instance;
    }

}
