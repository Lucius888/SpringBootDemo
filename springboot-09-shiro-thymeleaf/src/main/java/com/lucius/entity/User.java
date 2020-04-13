package com.lucius.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-04-13 14:37:22
 */
public class User implements Serializable {
    private static final long serialVersionUID = 235586144008274141L;
    
    private Integer id;
    /**
    * 用户名称
    */
    private String username;
    /**
    * 生日
    */
    private Date birthday;
    /**
    * 性别
    */
    private String sex;
    /**
    * 地址
    */
    private String address;
    
    private String password;
    
    private String permission;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

}