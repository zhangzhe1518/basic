package com.xun.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zhangzhe
 * jdk的动态代理：实现InvocationHandler接口重写invoke方法
 */
public class JdkProxyInvocation implements InvocationHandler {

    //目标对象
    private Object target;


    /**
     * 声明动态代理类的构造函数把代理对象注入
     * @param target 目标对象
     */
    public JdkProxyInvocation(Object target) {
        this.target = target;
    }

    /**
     * 处理代理对象方法的逻辑
     * @param proxy 代理对象
     * @param method 当前方法
     * @param args 参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("打印参数");
        System.out.println(Arrays.toString(args));
        System.out.println("调用原有对象方法。。。");
        Object result = method.invoke(target, args);
        System.out.println("方法结束");
        return result;
    }
}
