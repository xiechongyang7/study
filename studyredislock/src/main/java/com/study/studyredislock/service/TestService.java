package com.study.studyredislock.service;

import com.study.studyredislock.annotations.DistributeLock;
import com.study.studyredislock.entity.Demo;
import org.springframework.stereotype.Service;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/28 下午 4:23
 * @author xiechongyang
 */
@Service
public class TestService {

    @DistributeLock(name = "LOCK:TEST", value = "#demo.key.concat(#demo.value)",keepMills = 150000)
    public String distributedLockTest(Demo demo) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("哈哈哈哈哈哈哈哈哈哈哈");
        return "distributedLockTest";
    }
}
