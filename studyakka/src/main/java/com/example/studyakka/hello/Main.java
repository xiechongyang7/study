package com.example.studyakka.hello;

/**
 * @description
 * @since JDK1.8
 * @createTime 2019/4/9 上午 10:31
 * @author xiechongyang
 */
public class Main {

    public static void main(String[] arg){

//        1
        akka.Main.main(new String[]{Hello.class.getName()});

//         2
//        ActorSystem system = ActorSystem.create("Hello");
//        ActorRef a = system.actorOf(Props.create(HelloWorld.class), "helloWorld");
//        System.out.println(a.path());


    }
}
