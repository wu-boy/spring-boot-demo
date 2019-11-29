package com.wu.springboot.demo.web.rest.config;

import com.alibaba.fastjson.JSON;
import com.wu.springboot.demo.web.rest.pojo.dto.WebResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一结果处理
 * @author wusq
 * @date 2019/11/29
 */
@RestControllerAdvice("com.wu.springboot.demo.web.rest.controller")
public class MyResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return Boolean.TRUE;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        if (o instanceof String) {
            // 单独处理Controller返回值是String的情况
            return JSON.toJSONString(new WebResult(o));
        }
        if(o instanceof WebResult){
            return o;
        }
        return new WebResult(o);
    }
}
