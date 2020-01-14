package com.wu.springboot.demo.jms.rocketmq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 全局配置
 * @author wusq
 * @date 2020/1/11
 */
@Component
@ConfigurationProperties("global-config")
public class GlobalConfig {

    /**
     * 字符串主题
     */
    private String topicString;

    /**
     * 用户主题
     */
    private String topicUser;

    /**
     * 字符串消费者组
     */
    private String stringConsumerGroup;

    /**
     * 用户消费者组
     */
    private String userConsumerGroup;

    public String getTopicString() {
        return topicString;
    }

    public void setTopicString(String topicString) {
        this.topicString = topicString;
    }

    public String getTopicUser() {
        return topicUser;
    }

    public void setTopicUser(String topicUser) {
        this.topicUser = topicUser;
    }

    public String getStringConsumerGroup() {
        return stringConsumerGroup;
    }

    public void setStringConsumerGroup(String stringConsumerGroup) {
        this.stringConsumerGroup = stringConsumerGroup;
    }

    public String getUserConsumerGroup() {
        return userConsumerGroup;
    }

    public void setUserConsumerGroup(String userConsumerGroup) {
        this.userConsumerGroup = userConsumerGroup;
    }
}
