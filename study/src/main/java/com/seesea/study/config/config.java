package com.seesea.study.config;

import com.seesea.rely.aop.Inteceptor;
import com.seesea.rely.handle.UpAnHandle;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/10 17:24
 * @Author xie
 */
@Configuration
public class config {

    @Bean
    public Inteceptor get() throws NoSuchMethodException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        Inteceptor inteceptor = new UpAnHandle().upHandle("com.seesea.study.service");
        Pointcut pointcut = inteceptor.getClass().getDeclaredMethod("pointCut").getAnnotation(Pointcut.class);
        System.out.println("修cc之 c     值：\t" + pointcut.value());
        return inteceptor;
    }


    @Configuration
    public class RabbitConfig {

        @Bean
        public Queue Queue() {
            return new Queue("hello");
        }

    }
}
