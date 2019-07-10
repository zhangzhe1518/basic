package com.xun.proxy.jdk;

/**
 * @author zhangzhe
 * 被代理对象
 */
public class Man implements Person{

    @Override
    public void eat(String name,int age) {
        System.out.println("名字："+name+"，年芳："+age+"开始吃大餐");
    }

    @Override
    public void say() {
        System.out.println("Hello");
    }
}
