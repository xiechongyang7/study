package com.demo.monggodemo.dao;

import com.demo.monggodemo.entity.Phone;
import org.springframework.stereotype.Repository;

/**
 * @description
 * @author: xcy
 * @createTime: 2020/11/20 14:27
 */
@Repository
public class PhoneDao extends AbstractMongoDao<Phone> {

    @Override
    protected Class<Phone> getEntityClass() {
        return Phone.class;
    }
}
