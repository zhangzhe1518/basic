package com.xun.thread;

/**
 * @author zhangzhe
 * 创建多线程的第二种方式
 * 实现Runnable接口
 * 1.创建一个实现Runnable接口的类并重写run方法
 * 2.创建实现类的对象
 * 3.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 4.通过Thread类的对象调用start()方法
 */
public class ImpRunnable {

    public static void main(String[] args) {
        //创建线程1
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread);
        thread1.setName("寻");
        thread1.start();

        //创建线程2
        Thread thread2 = new Thread(myThread);
        thread2.setName("xun");
        thread2.start();

    }



    static class MyThread implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                if(i % 2 == 0){
                    System.out.println(Thread.currentThread().getName()+"->"+i);
                }
            }
        }
    }
}
