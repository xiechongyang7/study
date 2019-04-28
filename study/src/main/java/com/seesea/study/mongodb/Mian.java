package com.seesea.study.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/25 11:00
 * @Author xie
 */
@Service
public class Mian {

    @Autowired
    private TestDao testDao;

    public void go(TestBig testBig) {
        testDao.save(testBig);
    }

    public TestBig lets(String s) {
        return testDao.queryById(s);
    }
}
