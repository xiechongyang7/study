package com.example.studyakka.hello2;

import akka.actor.UntypedActor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/9 上午 10:41
 * @author xiechongyang
 */
public class Greeter extends UntypedActor {


    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onReceive(Object msg) throws InterruptedException {

        try {
            System.out.println("Greeter收到的数据为：" + objectMapper.writeValueAsString(msg));
            getSender().tell("Greeter工作完成。", getSelf());//给发送至发送信息.
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
