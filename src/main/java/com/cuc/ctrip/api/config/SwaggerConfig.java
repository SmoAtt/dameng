package com.cuc.ctrip.api.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration//配置类
@EnableSwagger2//开启Swagger2的自动配置
public class SwaggerConfig {
    @Bean
    public  Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cuc.ctrip.api.controller"))
                .build();
    }

        //配置文档信息
        private ApiInfo apiInfo() {
            Contact contact = new Contact("联系人名字", "http://xxx.xxx.com/联系人访问链接", "联系人邮箱");
            return new ApiInfo(
                    "火箭发射系统", // 标题
                    "学习演示如何发射火箭", // 描述
                    "v1.0", // 版本
                    "", // 组织链接
                    contact, // 联系人信息
                    "Apach 2.0 许可", // 许可
                    "许可链接", // 许可连接
                    new ArrayList<>()// 扩展
            );
        }
    }


