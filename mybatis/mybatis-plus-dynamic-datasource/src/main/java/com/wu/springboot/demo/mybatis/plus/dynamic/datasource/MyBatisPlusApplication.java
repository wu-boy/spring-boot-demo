package com.wu.springboot.demo.mybatis.plus.dynamic.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @author wusq
 * @date 2020/1/8
 */
@SpringBootApplication
@MapperScan("com.wu.springboot.demo.mybatis.plus.dynamic.datasource.dao")
public class MyBatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBatisPlusApplication.class, args);
    }
}
