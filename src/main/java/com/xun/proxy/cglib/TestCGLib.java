package com.xun.proxy.cglib;


/**
 * @Author zhangzhe
 * @Date 2019/7/10 16:04
 */
public class TestCGLib {
    public static void main(String[] args) {
        try {
            //获取CGLIB动态代理对象
            Person instance = (Person) new MyCGLibPerson().getInstance(Person.class);
            instance.fight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
