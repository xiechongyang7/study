package com.study.studyredislock.controller;

import com.study.studyredislock.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/28 下午 2:44
 * @author xiechongyang
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/distributedLockTest/{key}/{value}", method = {RequestMethod.POST, RequestMethod.GET})
    public String distributedLockTest(@PathVariable String key, @PathVariable String value) throws InterruptedException {
        return testService.distributedLockTest(key, value);
    }
}
