package com.wu.springboot.demo.mybatis.plus.test;

import com.wu.springboot.demo.mybatis.plus.dao.UserMapper;
import com.wu.springboot.demo.mybatis.plus.pojo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * UserMapper测试
 * @author wusq
 * @date 2019/11/25
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

    @Test
    public void selectTest() throws Exception {
        User user = userMapper.getByUsername("admin");
        System.out.println(user.getId());
    }

}
