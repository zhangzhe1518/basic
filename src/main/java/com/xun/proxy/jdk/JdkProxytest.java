package com.xun.proxy.jdk;

import java.lang.reflect.Proxy;

public class JdkProxytest {
    public static void main(String[] args) {

        Person man = new Man();
        //使用JDK提供的Proxy类下的newProxyInstance方法生成代理一个代理对象
        Person person = (Person) Proxy.newProxyInstance(
                //类加载器
                man.getClass().getClassLoader(),
                //绑定的接口，也就是把代理对象绑定到哪些接口上，可以是多个
                new Class[]{Person.class},
                //绑定代理对象
                new JdkProxyInvocation(man)
        );

        person.say("寻",23);
    }
}
