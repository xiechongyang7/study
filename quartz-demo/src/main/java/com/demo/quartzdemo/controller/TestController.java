package com.demo.quartzdemo.controller;

import com.demo.quartzdemo.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

/**
 * @description
 * @author: xcy
 * @createTime: 2020/8/3 16:00
 */
@Controller
public class TestController {


    @Autowired
    private QuartzService quartzService;


    /**
     * 增加任务
     * @return
     * @throws ClassNotFoundException
     */
    @GetMapping(value = "add")
    public Object addJob() throws ClassNotFoundException {


        HashMap<String,Object> map = new HashMap<>();
        map.put("name","--test job--");

        Class clz =  Class.forName("com.demo.quartzdemo.job.JobOne");

        quartzService.deleteJob("job2", "test");
        quartzService.addJob(clz, "job2", "test", "0/5 * * * * ? ", map);

        return "success";
    }


    /**
     * 增加任务
     * @return
     * @throws ClassNotFoundException
     */
    @GetMapping(value = "update")
    public Object updateJob() throws ClassNotFoundException {


        quartzService.updateJob("job2", "test", "0/6 * * * * ? ");

        return "success";
    }
}
