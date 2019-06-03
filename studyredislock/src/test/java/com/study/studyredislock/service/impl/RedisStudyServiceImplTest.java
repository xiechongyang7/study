package com.study.studyredislock.service.impl;

import com.study.studyredislock.service.IRedisStudyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisStudyServiceImplTest {

    @Autowired
    private IRedisStudyService redisStudyService;
    @Test
    public void testRedis() {

        redisStudyService.testRedisStr();
    }

    @Test
    public void testRedisHx() {
        redisStudyService.testRedisHx();
    }
}