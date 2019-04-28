package com.example.studymq.service.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/3/6 上午 11:36
 * @since JDK1.8
 */
@Service
public class SendImpl {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${encryption}")
    private String encryption;


    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend("exchange_test", "queue_one_key1", context);
    }

    public void sendw() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend("exchange_two", "queue_two_key", context);
    }

    public void sendf() {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType("text/plain");
        Message me = new Message(("哈哈" + encryption).getBytes(), messageProperties);
        System.out.println(encryption);
        rabbitTemplate.convertAndSend("exchange_two", "queue_two_key", me);
    }

    public void sendv() {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType("text/plain");
        messageProperties.setHeader("x-delay", 5000);
        Message me = new Message("哈哈".getBytes(), messageProperties);
        System.out.println(System.currentTimeMillis());
        rabbitTemplate.convertAndSend("exchange_delay", "queue_delay_key", me);
    }

    public void sendt() {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType("text/plain");
        messageProperties.setDelay(50000);
        Message me = new Message("哈哈".getBytes(), messageProperties);
        rabbitTemplate.convertAndSend("exchange_t", "queue_t_key", me);
//        rabbitTemplate.convertAndSend("exchange_two","queue_two_key", me);
    }
}
