package com.seesea.study;

import com.rabbitmq.client.BuiltinExchangeType;
import com.seesea.rely.handle.ScanHandle;
import com.seesea.seeseamq.config.RabbitMqConfig;
import com.seesea.seeseamq.model.ExchangeBuilder;
import com.seesea.seeseamq.model.QueueBindBuilder;
import com.seesea.seeseamq.model.QueueBuilder;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

import javax.annotation.PreDestroy;


@SpringBootApplication
@MapperScan(basePackages = "com.seesea.study.mapper")
//使用定时器
@EnableScheduling
public class StudyApplication implements CommandLineRunner {

    public static void main(String[] args) {
//        String[] strings = {"com.seesea.study.mapper","com.seesea.study.model"};
//        new ScanHandle(strings);
        SpringApplication.run(StudyApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        String[] strings = {"com.seesea.study.mapper","com.seesea.study.model"};
        ScanHandle.scan(strings);

    }


}
