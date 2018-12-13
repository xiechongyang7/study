package com.seesea.study.mapper;

import com.seesea.rely.annotation.FunAn;
import com.seesea.rely.annotation.Name;
import com.seesea.study.common.BaseMapper;
import com.seesea.study.model.User;

@Name(value = "UserMapper")
public interface UserMapper extends BaseMapper<User> {

    void Tes1t(String a);
    @FunAn
    void Test(String a);
}