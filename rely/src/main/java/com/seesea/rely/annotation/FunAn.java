package com.seesea.rely.annotation;

import java.lang.annotation.*;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/10 15:44
 * @Author xie
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FunAn {
    String name() default "一个方法";
}
