package com.seesea.study.service;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author xiechongyang
 * @description
 * @createtime 2018/12/27 15:18
 * @since JDK1.8
 */
@Service
public class TestMq {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void hah() {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("exchange_test", "queue_one_key1", "hah", correlationId);
    }

}
