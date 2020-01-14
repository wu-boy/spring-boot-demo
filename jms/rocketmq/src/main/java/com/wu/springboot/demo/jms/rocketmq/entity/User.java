package com.wu.springboot.demo.jms.rocketmq.entity;

import java.io.Serializable;

/**
 * @author wusq
 * @date 2020/1/11
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
