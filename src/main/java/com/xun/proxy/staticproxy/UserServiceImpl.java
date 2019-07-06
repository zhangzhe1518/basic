package com.xun.proxy.staticproxy;

public class UserServiceImpl implements UserService {
    @Override
    public void getUser() {
        System.out.println("我是被代理对象的getUser方法");
    }
}
