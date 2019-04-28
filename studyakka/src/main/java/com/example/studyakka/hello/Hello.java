package com.example.studyakka.hello;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/8 下午 8:59
 * @author xiechongyang
 */
public class Hello extends UntypedActor {

    @Override
    public void preStart() throws Exception {
        // create the greeter actor
        final ActorRef greeter = getContext().actorOf(Props.create(Greeter.class),"greeter");
        // tell it to perform the greeting
        greeter.tell(Greeter.Msg.GREET,getSelf());
    }

    @Override
    public void onReceive(Object msg) throws Exception {
        if (msg == Greeter.Msg.DONE) {
            // when the greeter is done, stop this actor and with it the application
            getContext().stop(getSelf());
        } else
            unhandled(msg);
    }
}
