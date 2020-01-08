package com.wu.springboot.demo.mybatis.plus.dynamic.datasource.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.wu.springboot.demo.mybatis.plus.dynamic.datasource.dao.UserMapper;
import com.wu.springboot.demo.mybatis.plus.dynamic.datasource.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wusq
 * @date 2020/1/8
 */
@Service
@Transactional
@DS("postgres") // 默认数据库
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper mapper;

    /**
     * 保存到Postgres库
     * @param user
     */
    @Override
    public void insertToPostgres(User user){
        mapper.insert(user);
    }

    /**
     * 保存到test库
     * DS注解可以用在类上和方法上，同时存在的话方法注解优先于类上注解
     * @param user
     */
    @Override
    @DS("test")
    public void insertToTest(User user){
        mapper.insert(user);
    }
}
