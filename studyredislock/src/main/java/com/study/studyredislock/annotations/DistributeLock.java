package com.study.studyredislock.annotations;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @description 定义分布式锁的注解
 * @since JDK1.8
 * @createTime 2019/4/28 下午 2:46
 * @author xiechongyang
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DistributeLock {

    /**
     * 锁的资源 key
     * 支持 spring el 表达式
     * @return
     */
    @AliasFor("name")
    String name() default "'default'";

    /**
     * 锁的资源 value
     * 支持spring el表达式
     * @return
     */
    @AliasFor("value")
    String value() default "'default'";

    /**
     * 持锁时间，单位毫秒
     * @return
     */
    long keepMills() default 5000;

    /**
     * 当获取失败时候的操作
     * @return
     */
    LockFailAction action() default LockFailAction.CONTINUE;

    public enum LockFailAction{
        /** 放弃 */
        GIVEUP,
        /** 继续 */
        CONTINUE;
    }

    /**
     * 重试的间隔时间，设置GIVEUP忽略此项
     */
    long sleepMills() default 200;

    /**
     * 重试次数
     */
    int retryTimes() default 5;
}
