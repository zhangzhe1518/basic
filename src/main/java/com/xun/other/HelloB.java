package com.xun.other;

public class HelloB extends HelloA {
    public HelloB() {
        System.out.println("HelloB构造方法");
    }

    {
        System.out.println("HelloB构造代码块");
    }

    static{
        System.out.println("HelloB静态代码块");
    }
}
