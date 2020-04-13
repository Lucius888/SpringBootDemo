/**
 * Copyright (C), Lucius
 * FileName: HelloSwagger
 * Author:
 * Date:     2020/4/13 17:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lucius.swagger.controller;


import com.lucius.swagger.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api("asdsa")
@RestController//就返回一个简单的页面
public class HelloSwagger {

    //给具体的请求注释
    @ApiOperation("hello注释")
    @GetMapping("/hello")
    public String helloSwagger(){
        return "hello";
    }
    @ApiOperation("user注释")
    @PostMapping("/user")
    public User user(){
        return new User();
    }
}
