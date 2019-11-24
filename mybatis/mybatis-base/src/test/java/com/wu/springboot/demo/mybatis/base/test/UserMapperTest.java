package com.wu.springboot.demo.mybatis.base.test;

import com.wu.springboot.demo.mybatis.base.dao.UserMapper;
import com.wu.springboot.demo.mybatis.base.pojo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * UserMapper测试
 * @author wusq
 * @date 2019/11/24
 */
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void insertTest() throws Exception {
        User user = new User();
        user.setUsername("admin");
        System.out.println(userMapper.insert(user));
    }

}
