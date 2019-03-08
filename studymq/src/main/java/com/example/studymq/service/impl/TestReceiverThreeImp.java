package com.example.studymq.service.impl;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/3/6 下午 2:05
 * @since JDK1.8
 */
//@Component
//@RabbitListener(
//        bindings = @QueueBinding(value = @Queue(value = "queue_t"),
//                exchange = @Exchange(value = "exchange_t"),
//                key = "queue_t_key"))
public class TestReceiverThreeImp {

    //    public void process(String hello) {
//        System.out.println("Receiver : " + hello+"+++++");
//    }
    @RabbitHandler
    public void process(Message message, Channel channel) {

        try {
            //        System.out.println("Receiver : " + hello+"+++++");
            byte[] body = message.getBody();
            String reviewJson = new String(body);
            System.out.println("收到消息:::::" + message.getMessageProperties().getDeliveryTag() + message.getMessageProperties().getCorrelationId() + reviewJson);
            /**
             * 确认消息消费成功
             * 第一个参数 是消息的tag 确定哪条消息被消费了
             * 第二个参数是 true:额外将比第一个参数指定的 delivery tag 小的消息一并确认了(批量确认) false:当前消息被消费了
             */
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (Exception e) {
            System.out.println("出现错误" + e.getMessage());
            /**
             * 重新投递
             * 第一个参数重新投递消息的tag
             * 第二个参数
             * 第二个参数说明如何处理这个失败消息。requeue 值为 true 表示该消息重新放回队列头，值为 false 表示放弃这条消息。
             */
            /**
             * 第一个参数指定 delivery tag，第二个参数说明如何处理这个失败消息。requeue 值为 true 表示该消息重新放回队列头，值为 false 表示放弃这条消息。
             * 一般来说，如果是系统无法处理的异常，我们一般是将 requeue 设为 false，例如消息格式错误，再处理多少次也是异常。
             * 调用第三方接口超时这类异常 requeue 应该设为 true。
             * 从 basicReject 方法参数可见，取消确认不支持批量操作（类似于 basicAck 的 multiple 参数）。所以，RabbitMQ 增加了 basicNack 方法以提供批量取消能力。
             */
            /**
             * 重复放入队列3次 还不能处理就放弃
             */
            if (message.getMessageProperties().getDeliveryTag() > 3) {
                System.out.println("消息已重复处理失败，拒绝再次接受::::" + e.getMessage());
                /**拒绝接受*/
                try {
                    channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
//                throw e;
            } else {
//                channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
                /**
                 * 第一次出错再次放回队列
                 */
                System.out.println("第" + message.getMessageProperties().getDeliveryTag() + "出错，再次放入队列");
                try {
                    channel.basicRecover();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
