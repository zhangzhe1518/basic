package com.xun.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author zhangzhe
 * @Date 2019/7/10 15:46
 * CGLIB动态代理对象
 * 实现MethodInterceptor类重写intercept方法
 */
public class MyCGLibPerson implements MethodInterceptor {

    /**
     * 获取CGLIB动态代理对象
     * @param calzz
     * @return
     * @throws Exception
     */
    public Object getInstance(Class<?> calzz)throws Exception{
        Enhancer enhancer = new Enhancer();
        //设置enhancer对象的父类
        enhancer.setSuperclass(calzz);
        //设置enhancer的回调对象
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //业务的增强
        System.out.println("给你一把枪，去打架吧");
        methodProxy.invokeSuper(o,objects);
        System.out.println("打赢了！！！");
        return o;
    }
}
