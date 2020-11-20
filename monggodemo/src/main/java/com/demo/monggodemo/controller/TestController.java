package com.demo.monggodemo.controller;

import com.demo.monggodemo.dao.PhoneDao;
import com.demo.monggodemo.entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;

/**
 * @description
 * @author: xcy
 * @createTime: 2020/11/20 14:28
 */
@Controller
public class TestController {

    @Autowired
    private PhoneDao phoneDao;

    @ResponseBody
    @PostMapping(value = "test1")
    public Object  test1() {
//        Phone phone = new Phone();
//        phone.setNum("17721424151");
//        phone.setName("苹果");
//        phone.setTime(new Date());
//        phoneDao.save(phone);
        Phone phone2 = new Phone();
        phone2.setNum("17721424152");
        phone2.setName("小米");
        phone2.setTime(new Date());
        phoneDao.save(phone2);
        Phone phone3 = new Phone();
        phone3.setNum("17721424153");
        phone3.setName("中通");
        phone3.setTime(new Date());
        phoneDao.save(phone3);
        return "";
    }

    @ResponseBody
    @PostMapping(value = "test2")
    public Object  test2() {
        Phone p = phoneDao.queryById("num","17721424151");
        System.out.println(p.toString());
        return p;
    }
}
