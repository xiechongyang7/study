package com.seesea.study.mongodb;

import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/25 10:59
 * @Author xie
 */
@Repository
public class TestDao extends MongoTest<TestBig> {
    @Override
    protected Class getEntityClass() {
        return TestDao.class;
    }
}
