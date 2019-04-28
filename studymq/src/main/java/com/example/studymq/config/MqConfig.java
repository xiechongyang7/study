package com.example.studymq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiechongyang
 * @description
 * @createtime 2018/12/27 15:22
 * @since JDK1.8
 */
@Configuration
public class MqConfig {

    @Autowired
    CachingConnectionFactory cachingConnectionFactory;

    /**
     * 1.定义direct exchange，绑定queueTest
     * 2.durable="true" rabbitmq重启的时候不需要创建新的交换机
     * 3.direct交换器相对来说比较简单，匹配规则为：如果路由键匹配，消息就被投送到相关的队列
     * fanout交换器中没有路由键的概念，他会把消息发送到所有绑定在此交换器上面的队列中。
     * topic交换器你采用模糊匹配路由键的原则进行转发消息到队列中
     * key: queue在该direct-exchange中的key值，
     * 当消息发送给direct-exchange中指定key为设置值时，消息将会转发给queue参数指定的消息队列
     *
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        DirectExchange directExchange =
                new DirectExchange("exchange_test", true, false);
        return directExchange;
    }

    /**
     * 定义队列1
     *
     * @return
     */
    @Bean
    public Queue queue_one() {
        /**
         * durable="true" 持久化 rabbitmq重启的时候不需要创建新的队列
         * auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
         * exclusive  表示该消息队列是否只在当前connection生效,默认是false
         */
        Queue queue = new Queue("queue_one", true, false, false);
        return queue;
    }

    /**
     * 将消息队列1和交换机进行绑定
     *
     * @return
     */
    @Bean
    public Binding binding_one() {
        return BindingBuilder.bind(queue_one()).to(directExchange()).with("queue_one_key1");
    }

    /**
     * queue linter 观察者 监听模式 当有消息到达时会在对应的队列上监听对象
     * @return
     */
//    @Bean
//    public SimpleMessageListenerContainer simpleMessageListenerContainer_one(){
//        SimpleMessageListenerContainer simpleMessageListenerContainer =
//                new SimpleMessageListenerContainer(cachingConnectionFactory);
//        simpleMessageListenerContainer.addQueues(queue_one());
//        simpleMessageListenerContainer.setExposeListenerChannel(true);
//        simpleMessageListenerContainer.setMaxConcurrentConsumers(1);
//        /**
//         * 设置确认模式 手工确认
//         */
//        simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        simpleMessageListenerContainer.setMessageListener(messageConsumerPutReview());
//        return simpleMessageListenerContainer;
//
//    }

    /**
     * 定义消费者
     */
//    @Bean
//    public HahListener messageConsumerPutReview(){
//        return new HahListener();
//    }
    /**
     * 消息确认机制
     * confirms给客户端一种轻量级的方式，能供跟踪那些消息被broker（中间商）宕掉或者网络失败的情况下重新发布
     * 确认并且保证消息被送达，提供了两种方式：发布确认和事务。（两者不可同时使用）在channel为事务时，不可引入确认模式；
     * 同样channel为确认模式下，不可使用事务
     */
//    @Bean
//    public MsgSendConfirmCallBack msgSendConfirmCallBack(){
//        return new MsgSendConfirmCallBack();
//    }

    /**
     * 定义rabbitmq template用于接收发送数据
     *
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(cachingConnectionFactory);
        /**
         * 若使用confirm-callback或者return-callback，必须配置publishConfirms或publisherReturn为true
         * 每个rabbitmq只能有一个confirm-callback和return-callback
         */
//        template.setConfirmCallback(msgSendConfirmCallBack());
//        template.setReturnCallback();
        /**
         * 使用return-callback时必须设置mandatory为true，或者在配置中设置mandatory-expression的值为true，
         * 可针对每次请求的消息去确定mandatory（委托）的Boolean的值
         * 只能在提供return-callback时使用 与mandatory互斥
         */

        //  template.setMandatory(true);
        return template;
    }
}
