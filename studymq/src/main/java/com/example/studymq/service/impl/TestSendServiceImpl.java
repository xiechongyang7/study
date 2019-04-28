package com.example.studymq.service.impl;


import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/3/4 下午 2:13
 * @since JDK1.8
 */
//@RabbitListener(containerFactory = "rabbitListenerContainerFactory",bindings = @QueueBinding(
//        value = @Queue(value = "queue_one"),
//        exchange = @Exchange(value = "exchange_test"),
//        key = "queue_one_key1"))
@Component
@RabbitListener(queues = "queue_one")
public class TestSendServiceImpl {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver : " + hello);
    }

}
