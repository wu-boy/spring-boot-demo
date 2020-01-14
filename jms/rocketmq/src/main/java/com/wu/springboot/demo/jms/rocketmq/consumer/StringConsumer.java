package com.wu.springboot.demo.jms.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author wusq
 * @date 2020/1/11
 */
@Service
@RocketMQMessageListener(consumerGroup = "${global-config.string-consumer-group}", topic = "${global-config.topic-string}")
public class StringConsumer implements RocketMQListener<String> {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onMessage(String message) {
        log.info("消费字符串消息{}", message);
        throw new RuntimeException();
    }
}
