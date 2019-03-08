package com.example.studymq.service.impl;


import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/3/4 下午 2:13
 * @author xiechongyang
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
