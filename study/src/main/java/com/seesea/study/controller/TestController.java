package com.seesea.study.controller;

import com.seesea.study.common.BaseController;
import com.seesea.study.common.BaseException;
import com.seesea.study.common.Result;
import com.seesea.study.model.Heihei;
import com.seesea.study.model.OneList;
import com.seesea.study.service.TestMq;
import com.seesea.study.service.TestService;
import com.seesea.study.service.impl.TestSeeMq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/7 14:33
 * @Author xie
 */
@Controller
public class TestController extends BaseController {

    @Autowired
    private TestService testService;
    @Autowired
    private TestMq testMq;

    @Autowired
    private TestSeeMq testSeeMq;
//    @ResponseBody
//    @GetMapping(value = "test/{num}")
//    public List<User> test(@PathVariable int num){
//        System.out.println("mmmm");
//        return testService.test(num);
//    }

    @ResponseBody
    @PostMapping(value = "test1")
    public Result test1(@RequestBody Heihei heihei) throws BaseException, IOException {
        logger.info("入" + heihei.toString());
        Result ii = heihei.getResult();
        logger.info("取" + ii.toString());
        OneList list = testService.test(heihei.getI());
        logger.info("拿" + list.toString());
        ii.setData(list);
        logger.info("回" + ii.toString());
        return ii;
    }

    @ResponseBody
    @PostMapping(value = "test2")
    public Object test2(@RequestBody Heihei heihei) throws BaseException, IOException {
        testMq.hah();
        return 1;
    }

    @ResponseBody
    @PostMapping(value = "test3")
    public Object test3(@RequestBody Heihei heihei) throws BaseException, IOException {
        testSeeMq.hah11();
        return 1;
    }
}
