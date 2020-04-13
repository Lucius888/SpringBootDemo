/**
 * Copyright (C), Lucius
 * FileName: User
 * Author:
 * Date:     2020/4/13 20:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lucius.swagger.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//这两个注解就是起到注释的作用
@ApiModel("用户实体类")//给具体的model注释
public class User {
    @ApiModelProperty("用户名")
    public String userName;
    @ApiModelProperty("密码")
    public String password;
}
