package com.example.reqdemo.controller;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/2/13 上午 11:08
 * @author xiechongyang
 */
public class TestModelVo {
    // byte short int double float char boolean long
    private String str;
    private MultipartFile file;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TestModelVo{");
        sb.append("str='").append(str).append('\'');
        sb.append(", file=").append(file);
        sb.append('}');
        return sb.toString();
    }
}
