package com.xun.proxy.staticproxy;

public class TestStaticProxy {

    public static void main(String[] args) {
        //创建被代理的类
        Person son = new Son();
        //创建代理对象
        Father father = new Father(son);
        //代理对象代理执行目标方法
        father.findLove();
    }
}
