package com.xun.thread;

/**
 * @author zhangzhe
 * 线程通信
 * 例题：生产者/消费者问题
 * 生产者将产品交给店员，而消费者从店员处取走产品，店员一次只能最多持有20个产品
 * 如果生产者试图生产更多的产品，店员会叫停止生产，当店员持有产品少于20个时再通知生产者生产，
 * 如果店员没有产品了就会通知消费者等一下，等有了产品再通知消费者来取走商品
 * */
public class ThreadCommunication {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Thread p1 = new Thread(producer,"生产者1");
        p1.start();
        Consumer consumer = new Consumer(clerk);
        Thread c1 = new Thread(consumer,"消费者1");
        c1.start();
    }
}

/**
 * 店员
 */
class Clerk{
    private int count = 0;

    /**
     * 生产产品
     */
    public synchronized void product(){
        if(count<20){
            count++;
            System.out.println(Thread.currentThread().getName()+"生产第"+count+"个产品");
            //生产了一个产品就唤醒对方线程开始消费
            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
    }

    /**
     * 消费产品
     */
    public synchronized void consume(){
        if(count>0){
            System.out.println(Thread.currentThread().getName()+"消费第"+count+"个产品");
            count--;
            //消费者只要消费了一个产品就告诉生产者可以生产了
            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
    }
}

/**
 * 生产者
 */
class Producer implements Runnable{

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName()+"生产产品。。。");
            clerk.product();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable{

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName()+"消费产品。。。");
            clerk.consume();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}