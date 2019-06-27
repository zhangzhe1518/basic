package com.xun.other;

public class HelloA {

    public HelloA() {
        System.out.println("HelloA构造方法");
    }

    {
        System.out.println("HelloA构造代码块");
    }

    static{
        System.out.println("HelloA静态代码块");
    }
}
