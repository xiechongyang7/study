package com.seesea.study.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description
 * @since JDK1.8
 * @createTime 2018/12/27 17:55
 * @author xiechongyang
 */
@Component
public class Task {
    @Scheduled(cron = "0/2 * * * * ? ")
    public void dayTask(){

        System.out.println("哈哈");

    }
}
