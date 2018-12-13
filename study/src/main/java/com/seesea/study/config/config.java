package com.seesea.study.config;

import com.seesea.rely.aop.Inteceptor;
import com.seesea.rely.handle.UpAnHandle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        return new UpAnHandle().upHandle("com.seesea.study.service");
    }
}
