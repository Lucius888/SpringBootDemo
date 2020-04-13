/**
 * Copyright (C), Lucius
 * FileName: SwaggerConfig
 * Author:
 * Date:     2020/4/13 17:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lucius.swagger.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2//开启swagger
public class SwaggerConfig {

    //通过配置文件来读取flag,适合多环境时使用
    @Value("${Swagger.enableFlag}")
    private Boolean flag;

    //配置swagger的Docker的bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Lucius")
                .apiInfo(apiInfo())
                //配置是否运行swagger-ui,默认true
                .enable(flag)
                .select()
                //指定需要扫描
                .apis(RequestHandlerSelectors.basePackage("com.lucius.swagger.controller"))
                //过滤不需要扫描地址
                //.paths(PathSelectors.ant("/lucius/**"))
                .build();
    }
    /*
    多人协同的时候可以设置多个组
    可以仿照上面这种扫描相应的类
     */
    @Bean
    public Docket docketA(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");}
    @Bean
    public Docket docketB(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");}

    //配置swagger信息 apiInfo
    //就是你访问swagger-ui.html这个网页显示的信息
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("Lucius","https://github.com/Lucius888","");

        return new ApiInfo(
                "Lucius的Seagger API文档",
                "为了生活",
                "v1.0",
                "https://github.com/Lucius888",
                contact,
                "Apache 2.0",
                "https://github.com/Lucius888",
                new ArrayList()
        );

    }

}
