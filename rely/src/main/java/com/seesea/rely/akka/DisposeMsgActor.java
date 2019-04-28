package com.seesea.rely.akka;

import akka.actor.AbstractActor;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/14 15:56
 * @Author xie
 */
public class DisposeMsgActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(Msg.class, t -> {
            //收到消息
            System.out.println(self() + " DisposeMsgActor 收到消息 " + sender() + ": " + t.getContent());
            System.out.println(self() + " DisposeMsgActor 有消息 : " + t.getContent());
        }).matchAny(t -> {
            System.out.println("沒有");
        }).build();
    }
}
