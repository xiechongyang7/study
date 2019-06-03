package com.study.studyredislock.service.impl;

import com.study.studyredislock.service.IRedisStudyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/6/3 下午 3:35
 * @author xiechongyang
 */
@Service
public class RedisStudyServiceImpl implements IRedisStudyService {

    Logger logger = LoggerFactory.getLogger(RedisStudyServiceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void testRedisStr() {

        logger.info("操作字符串 start");
        redisTemplate.opsForValue().set("hah","haha");
        Duration duration = Duration.ofSeconds(100);
        redisTemplate.opsForValue().set("hah2","hahah",duration);
        redisTemplate.opsForValue().set("hah2","hahah2",duration);
        redisTemplate.opsForValue().set("hah2","hahah3",30, TimeUnit.SECONDS);
//        redisTemplate.opsForValue().set
        logger.info("操作字符串 end");
    }

    @Override
    public void testRedisHx() {
        logger.info("操作哈希值 start");
        redisTemplate.opsForHash().put("key1","aa","bb");
        redisTemplate.opsForHash().putIfAbsent("key1","aa","bb2");
        redisTemplate.expire("key1",20,TimeUnit.SECONDS);
        logger.info("操作哈希值 start");
    }


}
