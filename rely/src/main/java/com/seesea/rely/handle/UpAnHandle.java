package com.seesea.rely.handle;

import com.seesea.rely.aop.Inteceptor;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/10 18:03
 * @Author xie
 */
public class UpAnHandle {


    public Inteceptor upHandle(String packName) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException {

        StringBuffer buffer = new StringBuffer("\"execution(public * ");
        buffer.append(packName);
        buffer.append(".TestService.test(..))  \"");
        Inteceptor inteceptor = new Inteceptor();
        Pointcut pointcut = inteceptor.getClass().getDeclaredMethod("pointCut").getAnnotation(Pointcut.class);


        InvocationHandler invocationHandler = Proxy.getInvocationHandler(pointcut);
        Field declaredField = invocationHandler.getClass().getDeclaredField("memberValues");
        declaredField.setAccessible(true);
        Map memberValues = (Map) declaredField.get(invocationHandler);
        // 修改 value 属性值
        memberValues.put("value", buffer.toString());
        // 获取 foo 的 value 属性值
        String newValue = pointcut.value();
        System.out.println("修改之后的 注解值：\t" + newValue);

        Pointcut pointcut2 = inteceptor.getClass().getDeclaredMethod("pointCut").getAnnotation(Pointcut.class);
        System.out.println("修改之    注解值：\t" + pointcut2.value());


        Inteceptor inteceptor2 = new Inteceptor();
        Pointcut pointcut3 = inteceptor2.getClass().getDeclaredMethod("pointCut").getAnnotation(Pointcut.class);
        System.out.println("修改之 注     值：\t" + pointcut3.value());

        return inteceptor2;
    }
}
