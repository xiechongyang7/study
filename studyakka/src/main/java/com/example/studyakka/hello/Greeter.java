package com.example.studyakka.hello;

import akka.actor.UntypedActor;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/9 上午 10:25
 * @author xiechongyang
 */
public class Greeter extends UntypedActor {
    public enum Msg {
        GREET, DONE;
    }

    @Override
    public void onReceive(Object o) throws Exception {

        if(o == Msg.GREET){
            System.out.println("hello world!");
            Thread.sleep(1000);
            getSender().tell(Msg.DONE,getSender());
        }else {
            unhandled(o);
        }

    }
}
