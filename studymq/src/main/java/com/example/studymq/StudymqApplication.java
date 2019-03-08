package com.example.studymq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class StudymqApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudymqApplication.class, args);
    }

}
