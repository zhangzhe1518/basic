package com.xun.thread.demo;

/**
 * @author zhangzhe
 * 多线程练习
 */
public class ThreadDemo {


    /**
     * demo1：创建两个线程
     * 线程1获取100以内的偶数
     * 线程2获取100以内的奇数
     */
    public static void main(String[] args) {
        //创建匿名内部类线程1
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if(i % 2 == 0){
                    System.out.println("线程："+Thread.currentThread().getName()+"偶数****："+i);
                }
            }
        }).start();

        //创建匿名内部类线程2
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                if(i % 2 != 0){
                    System.out.println("线程："+Thread.currentThread().getName()+"奇数----："+i);
                }
            }
        }).start();
    }


}
