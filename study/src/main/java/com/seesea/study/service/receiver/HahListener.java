package com.seesea.study.service.receiver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.seesea.study.service.callBack.MsgSendConfirmCallBack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

import java.io.IOException;

/**
 * @author xiechongyang
 * @description
 * @createtime 2018/12/27 15:57
 * @since JDK1.8
 */
public class HahListener implements ChannelAwareMessageListener {
    Logger logger = LoggerFactory.getLogger(MsgSendConfirmCallBack.class);

    /**
     * Callback for processing a received Rabbit message.
     * <p>Implementors are supposed to process the given Message,
     * typically sending reply messages through the given Session.
     *
     * @param message the received AMQP message (never <code>null</code>)
     * @param channel the underlying Rabbit Channel (never <code>null</code>)
     * @throws Exception Any.
     */
    @Override
    public void onMessage(Message message, Channel channel) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        logger.info(mapper.writeValueAsString(message));
        logger.info(mapper.writeValueAsString(channel));

        byte[] body = message.getBody();
        String reviewJson = new String(body);
        logger.info("收到消息1:::::" + message.getMessageProperties().getCorrelationId() + reviewJson);

        try {
            /**
             * 确认消息消费成功
             * 第一个参数 是消息的tag 确定哪条消息被消费了
             * 第二个参数是 true:额外将比第一个参数指定的 delivery tag 小的消息一并确认了(批量确认) false:当前消息被消费了
             */
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            logger.error("出现错误", e.getMessage());
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
                logger.error("消息已重复处理失败，拒绝再次接受::::" + e.getMessage());
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
                logger.info("第" + message.getMessageProperties().getDeliveryTag() + "出错，再次放入队列");
                try {
                    channel.basicRecover();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

        }


    }

}
