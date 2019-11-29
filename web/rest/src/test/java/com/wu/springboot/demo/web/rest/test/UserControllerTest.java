package com.wu.springboot.demo.web.rest.test;

import com.wu.springboot.demo.web.rest.pojo.dto.UserInsertDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Date;

/**
 * UserMapper测试
 * @author wusq
 * @date 2019/11/28
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void insertTest() throws Exception {
        UserInsertDto dto = new UserInsertDto();
        dto.setBirthday(new Date());
        dto.setEmail("xxx今天小雪@qq.com");
        dto.setIntegerValue(1);
        dto.setDoubleValue(1d);
        dto.setRange(1);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserInsertDto> entity = new HttpEntity<>(dto, headers);
        String str = testRestTemplate.postForObject("/users", entity, String.class);
        System.out.println(str);

    }

}
