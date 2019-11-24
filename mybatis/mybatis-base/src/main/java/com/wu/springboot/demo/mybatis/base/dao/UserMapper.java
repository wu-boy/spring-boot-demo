package com.wu.springboot.demo.mybatis.base.dao;

import com.wu.springboot.demo.mybatis.base.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 * @author wusq
 * @date 2019/6/29
 */
@Mapper
public interface UserMapper {
    int insert(User o);
}
