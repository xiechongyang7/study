package com.seesea.study.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/7 14:30
 * @Author xie
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
