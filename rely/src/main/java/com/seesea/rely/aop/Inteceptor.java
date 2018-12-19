package com.seesea.rely.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/10 16:52
 * @Author xie
 */
@Aspect
public class Inteceptor {

    private Logger logger = LoggerFactory.getLogger(Inteceptor.class);

    /**
     * 拦截类的入口--拦截所有controller类
     */
//    @Pointcut("execution(public * com.seesea.study.service.TestService.test(..))  ")
    @Pointcut("execution(public * com.seesea.study.controller.*.*(..))  ")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        Object[] o = joinPoint.getArgs();
        for(Object o1:o){
            logger.info("校验Before object"+o1);
        }
        String name = joinPoint.getSignature().getName();
        logger.info("校验Before name"+name);

    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
//        for(Object o1:o){
//            logger.info("嘻嘻啊"+o1);
//        }
//        String name = joinPoint.getSignature().getName();
        logger.info("校验 After"+joinPoint);
        Object[] o = joinPoint.getArgs();
        for(Object o1:o){
            logger.info("校验 After object"+o1);
        }
    }
}
