package com.example.reqdemo.controller;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/2/13 上午 11:15
 * @since JDK1.8
 */
public class TestModelSon extends TestModel {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
