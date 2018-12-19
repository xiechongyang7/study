package com.seesea.study.model;

import com.seesea.study.common.Result;
import com.seesea.study.common.Rsp;

import java.util.List;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/13 14:58
 * @Author xie
 */
public class OneList extends Rsp {
    private List<User> list;

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OneList{");
        sb.append("list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}
