package com.xun.thread;

import java.util.concurrent.*;

/**
 * @author zhangzhe
 * 死锁
 * 不同的线程分别占用对方所需要的资源不放弃，都在等待对方放弃自己想要的那个同步资源，造成循环等待的问题
 * 产生死锁的四个必要条件：
 * 1. 资源互斥：一个资源每次只能被一个线程使用（独木桥每次只能过一人）
 * 2. 请求与保持条件：一个线程因请求资源而阻塞时对已经获取的资源保持不放（乙不退出桥面，甲也不退出桥面）
 * 3. 不剥夺条件：线程已经获得的资源在未使用完之前不能被强行剥夺（甲不能强制乙退出，乙也不能强制甲退出）
 * 4. 循环等待：若干个线程之间形成一种头尾相连的循环等待资源的关系（乙不退出甲不能通过，甲不退出乙不能通过）
 */
public class DeadLock {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        //线程1
        new Thread(() -> {
            synchronized (s2) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                s1.append("s1");
                System.out.println(s1);
            }
        }).start();

        //线程2
        new Thread(() -> {
            synchronized (s1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                s2.append("s2");
                System.out.println(s2);
            }
        }).start();
    }

}
