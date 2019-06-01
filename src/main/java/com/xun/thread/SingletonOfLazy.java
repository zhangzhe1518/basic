package com.xun.thread;

/**
 * @author zhangzhe
 * 懒汉式单例模式(线程安全的)
 */
public class SingletonOfLazy {


}

class Lazy{
    /**
     * 私有构造方法
     */
    private Lazy(){}

    //懒汉的实例
    private static Lazy lazy = null;

    /**
     * 获取懒汉实例对象的方法
     */
    private static Lazy getLazy(){
        if(null != lazy){
            synchronized(Lazy.class){
                if(null == lazy){
                    lazy = new Lazy();
                }
            }
        }
        return lazy;
    }

}
