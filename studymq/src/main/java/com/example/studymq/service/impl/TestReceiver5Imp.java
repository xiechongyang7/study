package com.example.studymq.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/3/6 下午 2:05
 * @since JDK1.8
 */
@Component
@RabbitListener(
        containerFactory = "rabbitListenerContainerFactory",
        bindings = @QueueBinding(value = @Queue(value = "queue_delay"),
                exchange = @Exchange(value = "exchange_delay", arguments = {@Argument(name = "x-delayed-type", value = "direct")}, type = ExchangeTypes.DIRECT),
                key = "queue_delay_key"))
public class TestReceiver5Imp {

    @RabbitHandler
    public void process(@Payload String body, @Headers Map<String, Object> headers, Channel cc, Message message) throws Exception {
        System.out.println(System.currentTimeMillis());
//        Thread.sleep(5000);
        cc.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Receiver : " + body + mapper.writeValueAsString(headers));
    }

}
