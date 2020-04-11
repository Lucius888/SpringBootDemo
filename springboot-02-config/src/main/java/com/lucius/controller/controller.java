/**
 * Copyright (C), Lucius
 * FileName: controller
 * Author:
 * Date:     2020/4/10 14:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lucius.controller;


import com.lucius.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @Autowired
    Person person;

    @RequestMapping("test")
    public String configTest(){
        return person.toString();
    }

}

