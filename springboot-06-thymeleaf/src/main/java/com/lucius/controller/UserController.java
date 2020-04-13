package com.lucius.controller;

import com.lucius.entity.User;
import com.lucius.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-04-12 10:08:58
 */
@Controller
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @RequestMapping("/userlist")
    public String getUserList(Model model) {
        List<User> userList = userService.queryAllByLimit(1, 3);
        model.addAttribute("userList", userList);
        return "user";
    }
}