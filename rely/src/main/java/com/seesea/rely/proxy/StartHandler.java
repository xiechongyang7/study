package com.seesea.rely.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description
 * @since JDK1.8
 * @createTime 2018/12/27 17:19
 * @author xiechongyang
 */
public class StartHandler implements InvocationHandler {

    Star realStar;

    public StartHandler(Star realStar) {
        super();
        this.realStar = realStar;
    }

    //通过反射来调用方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object object = null;//接收方法的返回值
        System.out.println("方法执行前");

        if (method.getName().equals("sing")) {
            method.invoke(realStar, args);
        }

        System.out.println("方法执行后");
        return object;
    }

}
