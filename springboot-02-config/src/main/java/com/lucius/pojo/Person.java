/**
 * Copyright (C), Lucius
 * FileName: Person
 * Author:
 * Date:     2020/4/10 15:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lucius.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component//注册bean到容器中
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private int age;
    private int tel;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", tel=" + tel +
                ", name='" + name + '\'' +
                '}';
    }
}
