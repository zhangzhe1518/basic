package com.xun.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhangzhe
 * 实现Callable接口重写call()方法创建多线程
 * 1.创建Callable接口的实现类并重写call()方法
 * 2.将此线程要执行的操作声明在call()方法中
 * 3.创建Callable接口实现类的对象
 * 4.将Callable接口实现类的对象作为参数传递到FutureTask的构造器中，创建FutureTask的对象
 * 5.将FutureTask的对象作为参数传递到thread类的构造器中然后调用start()方法执行多线程
 * 6.使用get()接口获取call()方法执行结果的返回值
 */
public class ImplCallable implements Callable{

    @Override
    public Object call() throws Exception {
        //遍历100以内的偶数并返回所有偶数的和
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
                sum = sum+i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ImplCallable callableThread = new ImplCallable();
        FutureTask futureTask = new FutureTask(callableThread);
        new Thread(futureTask).start();
        try {
            //get()方法返回值即为futureTask构造器参数Callable接口的实现类重写的call()方法的返回值
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
