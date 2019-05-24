package com.study.studyredislock.aspect;

import com.study.studyredislock.annotations.Limiting;
import com.study.studyredislock.util.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/5/8 下午 3:04
 * @author xiechongyang
 */
@Aspect
@Component
public class LimitingAop {

    static Logger logger = LoggerFactory.getLogger(LimitingAop.class);

    @Autowired
    private RedisTemplate redisTemplate;


    @Pointcut("@annotation(com.study.studyredislock.annotations.Limiting)")
    private void putPoint(){
    }


    @Around("putPoint()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Method method = ((MethodSignature)pjp.getSignature()).getMethod();
        Limiting limiting = method.getAnnotation(Limiting.class);
        int frequency = limiting.frequency();
        long time = limiting.time();
        Object[] args = pjp.getArgs();// 方法的参数
//        HttpServletRequest request = null;
//        for (int i = 0; i < args.length; i++) {
//            if (args[i] instanceof HttpServletRequest) {
//                request = (HttpServletRequest) args[i];
//                break;
//            }
//        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();//获取request

        if (null == request){
            throw new Exception("空参");
        }
        String ip = IPUtils.getClientAddress(request);
        if(null == ip){
            throw new Exception("空IP");
        }
        String key = "LIMIT:"+ip;

        if(redisTemplate.hasKey(key)){
            long a  = redisTemplate.opsForValue().increment(key);
            if(frequency < a){
                throw new Exception("超过");
            }
        }else {
            redisTemplate.opsForValue().set(key,0,time);
        }
        return pjp.proceed();
    }
}
