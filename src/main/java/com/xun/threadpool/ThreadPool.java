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
        LinkedBlockingQueue queue = new LinkedBlockingQueue(3);
        ExecutorService service = Executors.newFixedThreadPool(5);
        ExecutorService service1 = Executors.newCachedThreadPool();
        ExecutorService service2 = Executors.newScheduledThreadPool(10);
        ExecutorService service3 = Executors.newSingleThreadExecutor();
        ExecutorService service4 = Executors.newWorkStealingPool(10);
        Future future = service.submit(new ImplCallable());
        try {
            Object o = future.get();
            System.out.println(o);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

    static class ImplCallable implements Callable {

        @Override
        public Object call() throws Exception {
            int sum = 0;
            for (int i = 0; i <= 100; i++) {
                if(i % 2 == 0){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                    sum = sum+i;
                }
            }
            return sum;
        }
    }
}
