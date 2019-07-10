package com.xun.proxy.staticproxy;

/**
 * @Author zhangzhe
 * @Date 2019/7/10 12:01
 * 静态代理类  代理儿子找对象
 */
public class Father {

    //目标对象(儿子类)
    private Person son;

    /**
     * 给代理对象设置目标对象
     */
    public Father(Person son) {
        this.son = son;
    }

    /**
     * 代理找对象功能
     */
    public void findLove(){
        System.out.println("根据儿子要求物色对象");
        son.findLove();
        System.out.println("找到了肤白貌美大长腿的对象，儿子很喜欢");
    }

}
