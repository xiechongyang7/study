package com.seesea.study.service.callBack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author xiechongyang
 * @description
 * @createtime 2018/12/27 15:53
 * @since JDK1.8
 */
public class MsgSendConfirmCallBack implements RabbitTemplate.ConfirmCallback {
    Logger logger = LoggerFactory.getLogger(MsgSendConfirmCallBack.class);

    // 只确认生产者消息发送成功，消费者是否处理成功不做保证
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        /**
         * correlationData 相关数据
         */
        logger.info("回调id:" + correlationData, s);
        if (b) {
            logger.info("消息接收成功");
        } else {
            logger.info("消息接收失败:" + s + "\n重新发送");
        }
    }
}
