package com.xun.proxy.jdk;

import java.lang.reflect.Proxy;

public class JdkProxytest {
    public static void main(String[] args) {

        //创建目标对象
        Person man = new Man();
        //使用JDK提供的Proxy.newProxyInstance方法生成目标对象的代理对象
        Person person = (Person) Proxy.newProxyInstance(
                //目标对象的类加载器
                man.getClass().getClassLoader(),
                //目标对象所实现的所有接口，可能是多个
                man.getClass().getInterfaces(),
                //绑定代理对象（代理对象的处理器）
                new JdkProxyInvocation(man)
        );

        person.eat("张莉",18);
        System.out.println("============================");
        person.say();
    }
}
