package com.seesea.study.service;

import com.seesea.study.mapper.UserMapper;
import com.seesea.study.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/7 14:34
 * @Author xie
 */
@Service
public class TestService {

    @Autowired
    private UserMapper userMapper;

    public List<User> test(int num){
        System.out.println("hhhhh");
        List list= userMapper.selectAll();
        return list;
    }
}
