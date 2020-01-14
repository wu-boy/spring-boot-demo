package com.wu.springboot.demo.jms.rocketmq.consumer;

import com.wu.springboot.demo.jms.rocketmq.entity.User;
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
@RocketMQMessageListener(consumerGroup = "${global-config.user-consumer-group}", topic = "${global-config.topic-user}")
public class UserConsumer implements RocketMQListener<User> {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onMessage(User user) {
        log.info("消费用户消息{}", user.getUsername());
    }
}
