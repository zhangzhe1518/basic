package com.xun.proxy.jdk;

/**
 * @author zhangzhe
 * 被代理对象
 */
public class Man implements Person{

    @Override
    public void say(String name,int age) {
        System.out.printf("名字：%s，年芳：%s%n",name,age);
    }
}
