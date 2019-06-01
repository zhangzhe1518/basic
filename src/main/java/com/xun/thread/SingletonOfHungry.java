package com.xun.thread;

/**
 * @author zhangzhe
 * 饿汉单例模式（本身就是线程安全的）
 */
public class SingletonOfHungry {


}

class Hungry{
    /**
     * 类加载时就初始化
     */
    private static final Hungry hungry = new Hungry();

    private Hungry(){}

    private static Hungry getHungry(){
        return hungry;
    }
}
