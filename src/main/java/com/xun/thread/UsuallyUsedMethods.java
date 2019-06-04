package com.xun.thread;

/**
 * @author zhangzhe
 * 经常使用的方法
 * Thread中的常用方法
 * 1.start()方法：启动当前线程，调用当前线程的run()方法
 * 2.run()：通常需要重写Thread中的此方法，将创建线程要执行的操作声明在此方法中
 * 3.CurrentThread()：是一个静态方法，返回执行当前代码的线程
 * 4.getName()：获取当前线程的名字
 * 5.setName()：设置当前线程的名字
 * 6.yidle()：不会释放锁，并重新回到可执行状态
 * 7.join()：在线程A中调用线程B的join()方法，此时线程A就要进入阻塞状态等待线程B执行完以后继续执行抢夺cpu资源
 * 8.sleep()：使当前线程进入睡眠状态不会释放锁，睡眠时间结束继续执行
 *
 * Object类的常用方法
 * 1.notify()：随机唤醒一个处于等待状态的线程
 * 2.notifyAll()：唤醒所有处于等待状态的线程
 * 3.wait()：使当前线程进入阻塞状态并释放锁，使用notify()或notifyAll()方法唤醒
 *
 * 线程的优先级
 * 1.获取当前线程的优先级getPriority()
 * 2.设置当前线程的优先级setPriority()
 */
public class UsuallyUsedMethods {

    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        //在线程启动之前为当前线程设置name
        thread1.setName("寻的线程");
        thread1.start();

        //给主线程设置name
        Thread.currentThread().setName("main线程");
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName()+"->"+i+"线程的优先级："+Thread.currentThread().getPriority());
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
                    System.out.println(Thread.currentThread().getName() + "->" + i+"线程的优先级："+Thread.currentThread().getPriority());
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
