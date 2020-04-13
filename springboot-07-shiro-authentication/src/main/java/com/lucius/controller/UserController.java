package com.lucius.controller;

import com.lucius.entity.User;
import com.lucius.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-04-12 19:21:41
 */
@Controller
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @RequestMapping({"/","/index"})
    public String toIndex(Model model){
        model.addAttribute("msg","hello");
        return "index";
    }
    @RequestMapping("/user/add")
    public String add(Model model){
        model.addAttribute("msg","hello");
        return "user/add";
    }

    @RequestMapping("/user/delet")
    public String delet(Model model){
        model.addAttribute("msg","hello");
        return "user/delet";
    }

    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        model.addAttribute("msg","hello");
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username,String password,Model model){
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        //封装用户
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        } catch (IncorrectCredentialsException e) {//密码错误
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }
    }

    @RequestMapping("/user/userList")
    public String userList(Model model){
        List<User> userList=userService.queryAllByLimit(1,3);
        model.addAttribute("userList",userList);
        return "user/userList";
    }

}