package com.lucius.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucius.entity.User;
import com.lucius.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-04-11 14:30:04
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    @RequestMapping("/getUserList")
    public Page<User> getUserList(@RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "2")Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        Page<User>  userList= userService.getUserList();
        return userList;
    }

//    @RequestMapping("/getUserList")
//    public PageInfo<User> getUserList(@RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "2")Integer pageSize){
//        PageHelper.startPage(pageNum, pageSize);
//        Page<User>  userList= userService.getUserList();
//        PageInfo<User> pageInfo = new PageInfo<User>(userList);
//        return pageInfo;
//    }

}