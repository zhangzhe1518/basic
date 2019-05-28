package com.xun.thread.demo;

/**
 * @author zhangzhe
 * 例子：模拟三个售票窗口同时售100张票
 * 在Java只我们使用同步机制来解决线程安全问题
 * 说明：操作共享数据的代码即为需要被同步的代码（多个线程共同操作的变量）
 * 方式1：同步代码块
 * synchronized(同步监视器){
 *  //需要被同步的代码
 * }
 * 方式2：同步方法
 */
public class SellTicketImplRunnable {

    public static void main(String[] args) {
        WindowRunnable windowRunnable = new WindowRunnable();
        Thread thread1 = new Thread(windowRunnable);
        Thread thread2 = new Thread(windowRunnable);
        Thread thread3 = new Thread(windowRunnable);
        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }


    static class WindowRunnable implements Runnable{
        private int ticket = 100;

        @Override
        public void run() {
            while(true){
                //使用synchronized代码块处理线程安全问题
                synchronized (WindowRunnable.class){
                    try {
                        //让步操作
                        Thread.sleep(0L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(ticket>0){
                        System.out.println(Thread.currentThread().getName()+"售票，票号为："+ticket);
                        ticket--;
                    }else{
                        //票售完了
                        break;
                    }
                }
            }

        }
    }
}
