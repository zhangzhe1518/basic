package com.xun.proxy.staticproxy;

/**
 * @Author zhangzhe
 * @Date 2019/7/10 11:59
 * 被代理类
 */
public class Son implements Person{
    @Override
    public void findLove() {
        System.out.println("找对象，肤白貌美大长腿");
    }
}
