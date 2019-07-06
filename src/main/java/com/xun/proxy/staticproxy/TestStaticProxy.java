package com.xun.proxy.staticproxy;

public class TestStaticProxy {

    public static void main(String[] args) {
        //创建被代理的对象
        UserServiceImpl userService = new UserServiceImpl();
        //创建静态代理对象，并把被代理的对象传入
        UserService userServiceProxy = new StaticUserServiceProxy(userService);
        //使用代理对象调用目标方法
        userServiceProxy.getUser();
    }
}
