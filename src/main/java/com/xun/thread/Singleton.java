package com.xun.thread;

/**
 * @author zhangzhe
 * 多线程下的单例模式
 */
public class Singleton {

    //使用volatile修饰，禁止jvm进行指令重排
    private volatile static Singleton singleton = null;

    //1.创建构造方法并私有化
    private Singleton() {
        System.out.println(Thread.currentThread().getName()+"我是构造方法Singleton()");
    }

    //DCL(双端检索机制)
    public static Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Singleton.getInstance();
            }).start();
        }
    }
}
