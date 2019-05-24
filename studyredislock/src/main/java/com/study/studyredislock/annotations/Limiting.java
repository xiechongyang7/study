package com.study.studyredislock.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/5/8 下午 3:04
 * @author xiechongyang
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Limiting {
    /**次数**/
    int frequency();
    /**时间**/
    long time() default 60000;
}
