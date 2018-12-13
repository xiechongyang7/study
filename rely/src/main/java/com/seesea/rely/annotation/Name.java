package com.seesea.rely.annotation;

import java.lang.annotation.*;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/7 14:46
 * @Author xie
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Name {
    String value() default "一个名字";
}
