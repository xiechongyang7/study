package com.seesea.rely.proxy;

import java.lang.reflect.Proxy;

/**
 * @author xiechongyang
 * @description
 * @createTime 2018/12/27 17:16
 * @since JDK1.8
 */
public class Client {
    public static void main(String[] args) {

        Star realStar = new RealStar();
        StartHandler handler = new StartHandler(realStar);

        Star pStar = (Star) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),//loader - 定义代理类的类加载器
                new Class[]{Star.class},//interfaces - 代理类要实现的接口列表
                handler);//h - 指派方法调用的调用处理程序

        //pStar.bookTicket();
        pStar.sing();

    }

}
