package com.example.reqdemo.controller;

import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/2/13 上午 11:08
 * @since JDK1.8
 */
public class TestModel {
    // byte short int double float char boolean long
    private String str;
    private int i;
    private Integer i2;
    private Double dou;
    private List<String> myList;
    private String[] myStrArry;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public Integer getI2() {
        return i2;
    }

    public void setI2(Integer i2) {
        this.i2 = i2;
    }

    public Double getDou() {
        return dou;
    }

    public void setDou(Double dou) {
        this.dou = dou;
    }

    public List<String> getMyList() {
        return myList;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public String[] getMyStrArry() {
        return myStrArry;
    }

    public void setMyStrArry(String[] myStrArry) {
        this.myStrArry = myStrArry;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TestModel{");
        sb.append("str='").append(str).append('\'');
        sb.append(", i=").append(i);
        sb.append(", i2=").append(i2);
        sb.append(", dou=").append(dou);
        sb.append(", myList=").append(myList);
//        sb.append(", shorts=").append(shorts == null ? "null" : Arrays.asList(shorts).toString());
        sb.append('}');
        return sb.toString();
    }
}
