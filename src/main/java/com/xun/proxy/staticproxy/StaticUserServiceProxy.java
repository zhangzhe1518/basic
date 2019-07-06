package com.xun.proxy.staticproxy;

/**
 * @author zhangzhe
 * 静态代理类
 */
public class StaticUserServiceProxy implements UserService {

    //目标对象，也就是被代理的类
    private UserService target;

    public StaticUserServiceProxy(UserService userService) {
        this.target = userService;
    }

    @Override
    public void getUser() {
        //对目标方法前后进行增强
        System.out.println("方法执行之前。。。。");
        //目标对象调用目标方法
        target.getUser();
        System.out.println("方法执行结束。。。。");
    }
}
