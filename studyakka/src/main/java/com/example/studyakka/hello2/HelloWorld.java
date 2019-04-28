package com.example.studyakka.hello2;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/9 上午 10:43
 * @author xiechongyang
 */
public class HelloWorld extends UntypedActor {

    ObjectMapper objectMapper = new ObjectMapper();
    ActorRef greeter;

    @Override
    public void preStart() {
        // create the greeter actor
        greeter = getContext().actorOf(Props.create(Greeter.class), "greeter");
        System.out.println("Greeter actor path：" + greeter.path());
        // tell it to perform the greeting
        greeter.tell(new Message(2, Arrays.asList("2", "dsf")), getSelf());
    }

    @Override
    public void onReceive(Object msg) {
        try {
            System.out.println("HelloWorld收到的数据为：" + objectMapper.writeValueAsString(msg));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
