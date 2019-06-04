package com.xun.thread.safe;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangzhe
 * 使用Look解决线程安全问题
 */
public class LookThread {

    public static void main(String[] args) {
        WinRunnable winRunnable = new WinRunnable();
        for (int i = 1; i <= 3; i++) {
            new Thread(winRunnable, "窗口-" + i).start();
        }
    }
}

class WinRunnable implements Runnable {
    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try{
                lock.lock();
                if(ticket>0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"卖出"+ticket+"号票");
                    ticket--;
                }else{
                    break;
                }
            }finally{
                lock.unlock();
            }
        }

    }
}
