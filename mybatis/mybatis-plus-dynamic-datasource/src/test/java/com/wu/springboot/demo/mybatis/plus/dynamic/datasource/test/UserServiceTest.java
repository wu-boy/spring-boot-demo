package com.wu.springboot.demo.mybatis.plus.dynamic.datasource.test;

import com.wu.springboot.demo.mybatis.plus.dynamic.datasource.pojo.entity.User;
import com.wu.springboot.demo.mybatis.plus.dynamic.datasource.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * UserService测试
 * @author wusq
 * @date 2020/1/8
 */
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void insertTest() throws Exception {
        User user = new User();
        user.setUsername("wusq");
        userService.insertToPostgres(user);
        userService.insertToTest(user);
    }

}
