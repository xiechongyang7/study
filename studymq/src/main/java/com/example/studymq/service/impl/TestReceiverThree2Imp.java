package com.example.studymq.service.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/3/6 下午 4:10
 * @since JDK1.8
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(value = @Queue(value = "queue_t"),
                exchange = @Exchange(value = "exchange_t"),
                key = "queue_t_key"))
public class TestReceiverThree2Imp {

    @RabbitHandler
    public void process(Message message) {
        System.out.println("哈哈" + new String(message.getBody()));
    }
}
