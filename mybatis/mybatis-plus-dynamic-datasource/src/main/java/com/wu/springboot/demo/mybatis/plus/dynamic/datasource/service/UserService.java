package com.wu.springboot.demo.mybatis.plus.dynamic.datasource.service;

import com.wu.springboot.demo.mybatis.plus.dynamic.datasource.pojo.entity.User;

/**
 * @author wusq
 * @date 2020/1/8
 */
public interface UserService {

    void insertToPostgres(User user);

    void insertToTest(User user);
}
