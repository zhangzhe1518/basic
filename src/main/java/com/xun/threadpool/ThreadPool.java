package com.xun.threadpool;

import java.util.concurrent.*;

/**
 * @author zhangzhe
 * 使用线程池创建线程
 * int corePoolSize,核心线程数
 * int maximumPoolSize,最大线程数
 * long keepAliveTime,非核心线程存活时间
 * TimeUnit unit,时间单位
 * BlockingQueue<Runnable> workQueue,阻塞队列
 * ThreadFactory threadFactory,线程工厂
 * RejectedExecutionHandler handler,拒绝策略
 */
public class ThreadPool {

    public static void main(String[] args) {

        //一池固定数线程
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
        //一池一个线程
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
        //一池N线程
        ExecutorService threadPool3 = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                threadPool3.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"：办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            //关闭线程池
            threadPool1.shutdown();
        }


    }


}
