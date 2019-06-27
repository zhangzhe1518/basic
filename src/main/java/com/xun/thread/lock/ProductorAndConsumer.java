package com.xun.thread.lock;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangzhe
 * 使用Lock方式实现生产者和消费者问题
 */
public class ProductorAndConsumer {

    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3;
        int c = 3;
        System.out.println(a==b);
        System.out.println(a==c);


        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);
        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.execute(productor);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(consumer);
        threadPool.shutdown();
        cachedThreadPool.shutdown();


        Executors.newFixedThreadPool(5);
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(1);

    }

}

/**
 * 店员
 */
class Clerk{
    //Lock同步锁
    private Lock lock = new ReentrantLock();
    //Condition控制线程通信
    private Condition condition = lock.newCondition();
    //共享数据商品
    private int product = 0;

    /**
     * 进货
     */
    public void get(){
        //获取锁
        lock.lock();
        try{
            while (product >= 10){
                System.out.println("商品已满");
                try {
                    //将当前线程挂起
                    condition.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + "：" + ++product);
            //唤醒线程
            condition.signalAll();
        }finally {
            //释放锁 必须放在finally中
            lock.unlock();
        }

    }

    /**
     * 售货
     */
    public void sale(){
        //获取同步锁
        lock.lock();
        try{
            while (product <= 0){
                System.out.println("缺货");
                try {
                    //缺货，将线程挂起等待生产
                    condition.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + "：" + --product);
            //货物上架，唤醒线程
            condition.signalAll();
        }finally{
            //释放锁
            lock.unlock();
        }
    }
}


/**
 * 生产者
 */
class Productor implements Runnable{
    private Clerk clerk;

    public Productor(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        //生产产品
        for (int i = 0; i < 20; i++) {
            clerk.get();
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        //消费产品
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}
