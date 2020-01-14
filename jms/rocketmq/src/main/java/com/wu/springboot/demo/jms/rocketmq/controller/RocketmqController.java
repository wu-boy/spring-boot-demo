package com.wu.springboot.demo.jms.rocketmq.controller;

import com.wu.springboot.demo.jms.rocketmq.config.GlobalConfig;
import com.wu.springboot.demo.jms.rocketmq.entity.User;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wusq
 * @date 2020/1/10
 */
@RestController
@RequestMapping("rocketmq")
public class RocketmqController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GlobalConfig globalConfig;

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 同步发送
     * 页面访问http://localhost:8080/rocketmq/sync
     * @throws Exception
     */
    @GetMapping("sync")
    public void sync(){
        SendResult sendResult = rocketMQTemplate.syncSend(globalConfig.getTopicString(), "Hello world!");
        log.info("同步发送字符串{}, 发送结果{}", globalConfig.getTopicString(), sendResult);

        User user = new User();
        user.setId("1");
        user.setUsername("wusq");
        sendResult = rocketMQTemplate.syncSend(globalConfig.getTopicUser(), user);
        log.info("同步发送对象{}, 发送结果{}", globalConfig.getTopicUser(), sendResult);
    }

    /**
     * 异步发送
     * 页面访问http://localhost:8080/rocketmq/async
     * @throws Exception
     */
    @GetMapping("async")
    public void async(){

        rocketMQTemplate.asyncSend(globalConfig.getTopicString(), "Hello world!", new SendCallback() {
            @Override
            public void onSuccess(SendResult var1) {
                log.info("异步发送成功{}", var1);
            }

            @Override
            public void onException(Throwable var1) {
                log.info("异步发送失败{}", var1);
            }
        });
    }

    /**
     * 单向发送
     * 页面访问http://localhost:8080/rocketmq/oneway
     * @throws Exception
     */
    @GetMapping("oneway")
    public void oneway(){
        rocketMQTemplate.sendOneWay(globalConfig.getTopicString(), "Hello world!");
        log.info("单向发送");
    }
}
