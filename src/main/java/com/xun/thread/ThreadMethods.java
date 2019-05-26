package com.xun.thread;

/**
 * @author zhangzhe
 * Thread中的常用方法
 * 1.start()方法：启动当前线程，调用当前线程的run()方法
 * 2.run()：通常需要重写Thread中的此方法，将创建线程要执行的操作声明在此方法中
 * 3.CurrentThread()：是一个静态方法，返回执行当前代码的线程
 * 4.getName()：获取当前线程的名字
 * 5.setName()：设置当前线程的名字
 * 6.yidle()：释放当前cpu的执行权
 * 7.join()：在线程A中调用线程B的join()方法，此时线程A就要进入阻塞状态等待线程B执行完以后继续执行抢夺cpu资源
 * 8.sleep()：使当前线程进入睡眠状态并让出cpu资源，指定时间到了继续抢夺cpu资源
 */
public class ThreadMethods {

    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        //在线程启动之前为当前线程设置name
        thread1.setName("寻的线程");
        thread1.start();

        //给主线程设置name
        Thread.currentThread().setName("main线程");
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName()+"->"+i);
            }
            //测试join方法，使当前线程进入阻塞状态，等代要join的线程执行完毕
            if(i==1){
                try {
                    //main线程进入阻塞状态，等待thread1线程执行完毕才能继续
                    System.out.println("main线程进入阻塞状态");
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "->" + i);
                    try {
                        sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //代码注释掉，去测试join方法
                /*if(i>50){
                    //释放当前cpu的执行权
                    yield();
                    System.out.println("释放当前线程的cpu使用权并睡眠一下");
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/
            }
        }
    }
}
