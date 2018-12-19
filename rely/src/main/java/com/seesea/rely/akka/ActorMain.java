package com.seesea.rely.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.BalancingPool;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/14 15:58
 * @Author xie
 */
public class ActorMain {
    public static void main(String[] args) {
        //生成角色系统
        ActorSystem system = ActorSystem.create("msgSystem");

        //生成角色 ProduceMsgActor
        ActorRef produceMsgActor = system.actorOf(new BalancingPool(3).props(Props.create(ProduceMsgActor.class)),"ProduceMsgActor");
        //生成角色 DisposeMsgActor
        ActorRef disposeMsgActor = system.actorOf(new BalancingPool(2).props(Props.create(DisposeMsgActor.class)),"DisposeMsgActor");

        //给produceMsgActor发消息请求
        produceMsgActor.tell("生產一個消息",ActorRef.noSender());
    }
}
