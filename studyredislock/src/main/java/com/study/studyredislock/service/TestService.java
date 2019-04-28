package com.study.studyredislock.service;

import com.study.studyredislock.annotations.DistributeLock;
import org.springframework.stereotype.Service;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/28 下午 4:23
 * @author xiechongyang
 */
@Service
public class TestService {

    @DistributeLock(name = "TestService_distributedLockTest", value = "#key.concat(#value)")
    public String distributedLockTest(String key, String value) throws InterruptedException {
        Thread.sleep(5000L);
        return "distributedLockTest";
    }
}
