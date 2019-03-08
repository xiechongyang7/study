package com.seesea.study.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/25 10:57
 * @Author xie
 */
@Document(collection = "testBig")
public class TestBig {

    @Id
    @Indexed
    private int id;
    private String data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
