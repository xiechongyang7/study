package com.demo.monggodemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @description
 * @author: xcy
 * @createTime: 2020/11/20 14:12
 */
@Document(collection = "test_phone")
public class Phone {

    @Id
    @Indexed
    private String num;
    private String name;
    private Date time;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
