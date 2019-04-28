package com.seesea.study.service.impl;

import com.seesea.seeseamq.model.ConsumerInfo;
import com.seesea.seeseamq.service.Impl.RabbitmqListener;
import org.springframework.stereotype.Service;

/**
 * @author xiechongyang
 * @description
 * @createTime 2019/1/17 16:11
 * @since JDK1.8
 */
public class SeeseaListener extends RabbitmqListener {


    /**
     * 回调参数
     *
     * @param body
     */
    @Override
    public void callback(byte[] body) {
        System.out.println("收到消息:::" + String.valueOf(body));
    }

    /**
     * 回调参数信息
     *
     * @return 消费者信息
     */
    @Override
    public ConsumerInfo getConsumerInfo() {
        ConsumerInfo consumerInfo = new ConsumerInfo("seesea.q", "test");
        return null;
    }
}
