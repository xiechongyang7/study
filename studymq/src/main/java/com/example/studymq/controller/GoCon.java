package com.example.studymq.controller;

import com.example.studymq.service.impl.SendImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/3/6 下午 1:44
 * @since JDK1.8
 */
@Controller
public class GoCon {

    @Autowired
    SendImpl send;

    @RequestMapping(value = "/go/{a}")
    public Object getViewable(@PathVariable int a) {
//        send.send();
        if (a == 2) {
            send.sendw();
        } else if (a == 3) {
            send.sendt();
        } else if (a == 4) {
            send.sendf();
        } else if (a == 5) {
            send.sendv();
        }
        return "hah";
    }

}
