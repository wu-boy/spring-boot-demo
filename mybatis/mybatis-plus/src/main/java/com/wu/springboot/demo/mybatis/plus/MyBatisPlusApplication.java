package com.wu.springboot.demo.mybatis.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @author wusq
 * @date 2019/11/25
 */
@SpringBootApplication
@MapperScan("com.wu.springboot.demo.mybatis.plus")
public class MyBatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBatisPlusApplication.class, args);
    }
}
