package com.wu.springboot.demo.web.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger2配置类
 * @author wusq
 * @date 2019/12/1
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    // 名字可以自定义，改成Authorization也可以
    private static final String TOKEN = "token";

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    /**
     * 配置文档信息
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Spring Boot集成Swagger2")
                .contact(new Contact("程序兔兔", "https://github.com/wu-boy", "wu.work@qq.com"))
                .version("0.1")
                .description("Spring Boot集成Swagger2的demo")
                .build();
    }

    private List<ApiKey> securitySchemes() {
        List<ApiKey> result = new ArrayList<>();
        result.add(new ApiKey(TOKEN, TOKEN, "header"));
        return result;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> result = new ArrayList<>();
        result.add(SecurityContext.builder().securityReferences(defaultAuth()).build());
        return result;
    }

    List<SecurityReference> defaultAuth() {
        List<SecurityReference> result = new ArrayList<>();
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = new AuthorizationScope("global", "accessEverything");
        result.add(new SecurityReference(TOKEN, authorizationScopes));
        return result;
    }

}
