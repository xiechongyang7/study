package com.seesea.study.service.impl;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.MessageProperties;
import com.seesea.seeseamq.model.hook.Msg;
import com.seesea.seeseamq.service.Impl.RabbitmqSender;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

/**
 * @author xiechongyang
 * @description
 * @createtime 2018/12/27 15:18
 * @since JDK1.8
 */
@Service
public class TestSeeMq {

//    @Autowired
//    private RabbitmqSender rabbitmqSender;


    public void hah11() throws IOException {
        String str = "this is a msg";
        RabbitmqSender rabbitmqSender = new RabbitmqSender();
        rabbitmqSender.send(new Msg() {
            @Override
            public String getExchange() {
                return "seesea.ex";
            }

            @Override
            public String getRoutingKey() {
                return "seesea.key";
            }

            @Override
            public AMQP.BasicProperties getBasicProperties() {
                return MessageProperties.PERSISTENT_TEXT_PLAIN;
            }

            @Override
            public byte[] getBody() {
                return str.getBytes();
            }
        });
    }

}
