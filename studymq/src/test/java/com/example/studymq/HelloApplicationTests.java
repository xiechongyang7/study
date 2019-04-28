package com.example.studymq;

import com.example.studymq.service.impl.SendImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/3/6 上午 11:55
 * @since JDK1.8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HelloApplicationTests {

    @Autowired
    private SendImpl sender;

    @Test
    public void hello() throws Exception {
        sender.send();
    }

}