package com.xun.thread.demo;

/**
 * @author zhangzhe
 * 例子：模拟三个售票窗口同时售100张票
 * 出现三个窗口同时出售票号为100的先不处理
 */
public class SellTicket {

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
                //卖票
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
