package com.seesea.rely.handle;

import com.seesea.rely.annotation.FunAn;
import com.seesea.rely.annotation.Name;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/7 14:51
 * @Author xie
 */
public final class ScanHandle {

    public static void scan(String[] packNames) {
        for (String packName : packNames) {
            /**
             * 扫描类
             */
            Reflections reflections = new Reflections(packName);
            Set<Class<?>> clzList = reflections.getTypesAnnotatedWith(Name.class);

            for (Class clz : clzList) {
                Name annotation = (Name) clz.getAnnotation(Name.class);
                System.out.println(annotation.value());
            }

            /**
             * 扫描方法
             */
            for (Class clz : clzList) {
                Method[] methods = clz.getDeclaredMethods();
                for (Method method : methods) {
                    FunAn funAn = method.getAnnotation(FunAn.class);
                    if (null != funAn) {
                        System.out.println(funAn.name());
                    }
                }
            }

        }
    }

}
