package com.xun.thread;

/**
 * @author zhangzhe
 * 创建多线程方式一：
 * 1.通过继承Thread类
 * 2.重写Thread类的run()方法，将此线程要执行的操作声明在run方法中
 * 3.创建Thread类的对象
 * 4.调用Thread的start()方法
 */

public class CreateThread {

    public static void main(String[] args) {
        //线程1
        Thread thread1 = new MyThread();
        thread1.start();
        //主线程
        add();
    }

    private static void add() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + "****");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    static class MyThread extends Thread {

        @Override
        public void run() {
            //例子：遍历100以内的所有偶数
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
