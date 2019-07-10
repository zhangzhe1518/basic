package com.xun.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zhangzhe
 * Jdk的动态代理类
 * jdk的动态代理：实现InvocationHandler接口重写invoke方法
 */
public class JdkProxyInvocation implements InvocationHandler {

    //目标对象（被代理的类）
    private Object target;

    /**
     * 声明动态代理类的构造函数把要代理的对象注入动态代理类中
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
        Object result = null;
        System.out.println("打印参数："+Arrays.toString(args));
        //动态代理可以针对特定的方法进行增强
        if("eat".equals(method.getName())){
            //执行方法前的操作
            System.out.println("大厨做了好吃的。。。");
            //调用invoke方法执行真实方法
            result = method.invoke(target, args);
            //方法执行完之后的操作
            System.out.println("饱了，好撑！！！");
        }else{
            result = method.invoke(target,args);
        }
        return result;
    }
}
