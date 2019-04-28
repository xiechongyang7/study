package com.seesea.study.config;

import com.rabbitmq.client.BuiltinExchangeType;
import com.seesea.seeseamq.base.SeeseaMqException;
import com.seesea.seeseamq.config.RabbitMqConfig;
import com.seesea.seeseamq.model.ExchangeBuilder;
import com.seesea.seeseamq.model.QueueBindBuilder;
import com.seesea.seeseamq.model.QueueBuilder;
import com.seesea.seeseamq.service.Impl.RabbitmqSender;
import com.seesea.study.service.impl.SeeseaListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/1/17 16:14
 * @since JDK1.8
 */
@Configuration
public class mq2 {

    @Bean
    public SeeseaListener getRabbitmqSender() throws IOException, SeeseaMqException {
        System.out.println("使用mq");
        ExchangeBuilder exchangeBuilder = ExchangeBuilder.custom().setExchange("seesea.ex").setType(BuiltinExchangeType.DIRECT).build();
        QueueBuilder queueBuilder = QueueBuilder.custom().setQueue("seesea.q").build();
        QueueBindBuilder bindBuilder = QueueBindBuilder.custom().setExchange("seesea.ex").setQueue("seesea.q").setRoutingKey("seesea.key").build();
//        RabbitMqConfig rabbitMqConfig =
//                new RabbitMqConfig("amqp://rmfntena:nQimb2Sns3DRlLRJv0YntF88g_AALCJ9@mustang.rmq.cloudamqp.com/rmfntena",
//                        "rmfntena",
//                        "nQimb2Sns3DRlLRJv0YntF88g_AALCJ9",
//                        exchangeBuilder,queueBuilder,bindBuilder);

        RabbitMqConfig rabbitMqConfig =
                new RabbitMqConfig("127.0.0.1", "5672", "guest", "guest",
                        exchangeBuilder, queueBuilder, bindBuilder);

        SeeseaListener seeseaListener = new SeeseaListener();
        return seeseaListener;
    }
}
