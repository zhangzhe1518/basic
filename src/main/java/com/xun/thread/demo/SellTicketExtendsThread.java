package com.xun.thread.demo;

public class SellTicketExtendsThread {

    public static void main(String[] args) {
        WindowThread thread1 = new WindowThread();
        WindowThread thread2 = new WindowThread();
        WindowThread thread3 = new WindowThread();
        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }


    static class WindowThread extends Thread{
        private static int ticket = 100;

        @Override
        public void run() {
            while(true){
                //使用synchronized代码块处理线程安全问题
                synchronized (SellTicketExtendsThread.class){
                //synchronized (this){错误的
                    try {
                        //让步操作
                        Thread.sleep(10L);
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
