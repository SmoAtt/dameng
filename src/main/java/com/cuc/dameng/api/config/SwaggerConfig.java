package com.cuc.dameng.api.config;


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
                .apis(RequestHandlerSelectors.basePackage("com.cuc.dameng.api.controller"))
                .build();
    }

        //配置文档信息
        private ApiInfo apiInfo() {
            Contact contact = new Contact("码上花心思", "https://www.fjnu.edu.cn/联系人访问链接", "1342456515@qq.com");
            return new ApiInfo(
                    "物流信息分析系统", // 标题
                    "数据存储共享模块，数据库外部接口", // 描述
                    "v1.0", // 版本
                    "", // 组织链接
                    contact, // 联系人信息
                    "", // 许可
                    "", // 许可连接
                    new ArrayList<>()// 扩展
            );
        }
    }


