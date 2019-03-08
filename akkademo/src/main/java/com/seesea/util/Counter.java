//package com.seesea.util;
//
//import akka.actor.AbstractLoggingActor;
//import akka.japi.pf.ReceiveBuilder;
//
///**
// * @description
// * @since JDK1.8
// * @createTime 2019/1/30 上午 11:18
// * @author xiechongyang
// */
//public class Counter extends AbstractLoggingActor {
//
//    @Override
//    public Receive createReceive() {
//        return null;
//    }
//
//    static class Message { }
//
//    private int counter = 0;
//
//    {
//        receive(ReceiveBuilder
//                .match(Message.class, this::onMessage)
//                .build()
//        );
//    }
//
//    private void onMessage(Message message) {
//        counter++;
//        log().info("Increased counter " + counter);
//    }
//}
