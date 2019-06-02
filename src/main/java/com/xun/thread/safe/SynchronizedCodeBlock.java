package com.xun.thread.safe;

/**
 * @author zhangzhe
 * Synchronized代码块解决线程安全问题
 * 例子：三个窗口卖100张票的问题
 */
public class SynchronizedCodeBlock {


    public static void main(String[] args) {

        WindowsRunnable winRunnable = new WindowsRunnable();
        Thread thread1 = new Thread(winRunnable);
        Thread thread2 = new Thread(winRunnable);
        Thread thread3 = new Thread(winRunnable);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}


/**
 * 卖票线程继承Runnable接口
 */
class WindowsRunnable implements Runnable {
    private static Integer ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (WindowsRunnable.class) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + "卖出" + ticket + "号票");
                    //票数减1
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
