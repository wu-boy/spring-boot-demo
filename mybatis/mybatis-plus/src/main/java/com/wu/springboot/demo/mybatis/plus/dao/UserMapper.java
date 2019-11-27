package com.wu.springboot.demo.mybatis.plus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wu.springboot.demo.mybatis.plus.pojo.entity.User;

/**
 * @author wusq
 * @date 2019/11/25
 */
public interface UserMapper extends BaseMapper<User> {
    User getByUsername(String username);
}
