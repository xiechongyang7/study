package com.seesea.study.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author xiechongyang
 * @description
 * @createTime 2018/12/27 17:55
 * @since JDK1.8
 */
@Component
public class Task {
    @Scheduled(cron = "0/2 * * * * ? ")
    public void dayTask() {

        System.out.println("哈哈");

    }
}
