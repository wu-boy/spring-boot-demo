package com.wu.springboot.demo.web.rest.controller;

import com.wu.springboot.demo.web.rest.pojo.dto.UserInsertDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * RestController测试
 * @author wusq
 * @date 2019/11/28
 */
@RestController
@RequestMapping("users")
public class UserController {

    /**
     * 启动后，浏览器访问http://localhost:8080/users/1
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public UserInsertDto get(@PathVariable int id){
        UserInsertDto user = new UserInsertDto();
        user.setIntegerValue(id);
        user.setBirthday(new Date());
        user.setEmail("xxx@qq.com");
        return user;
    }

    @PostMapping()
    public String insert(@RequestBody @Valid UserInsertDto dto){
        System.out.println(dto.getBirthday());
        System.out.println(dto.getEmail());
        return "success";
    }
}
