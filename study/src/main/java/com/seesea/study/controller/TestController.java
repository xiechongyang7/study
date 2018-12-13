package com.seesea.study.controller;

import com.seesea.study.model.User;
import com.seesea.study.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/7 14:33
 * @Author xie
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @ResponseBody
    @GetMapping(value = "test/{num}")
    public List<User> test(@PathVariable int num){
        System.out.println("mmmm");
        return testService.test(num);

    }


}
