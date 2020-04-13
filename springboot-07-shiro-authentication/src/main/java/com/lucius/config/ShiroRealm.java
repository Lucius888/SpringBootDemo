/**
 * Copyright (C), Lucius
 * FileName: ShiroRealm
 * Author:
 * Date:     2020/4/12 12:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lucius.config;

import com.lucius.entity.User;
import com.lucius.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


public class ShiroRealm extends AuthorizingRealm {

        @Autowired
        private UserService userService;

        /**
         * 授权
         */
        @Override
        protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
            return null;
        }

        /**
         * 认证
         */
        @Override
        protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
            System.out.println("执行了认证");
            // 获取用户输入的用户名
            // 获取用户输入的用户名和密码
            String userName = (String) token.getPrincipal();
            String password = new String((char[]) token.getCredentials());

            // 通过用户名到数据库查询用户信息
            User user = userService.queryByUserName(userName);
            //没有此人，返回null,自动显示异常
            if (user == null) {
                return null;
            }
            /*
            在这里对密码进行MD5盐加密
            盐值由用户名产生
            注意与HashedCredentialsMatcher中使用的算法和加密次数保持一致
            tohex也要与其保持一致类型
             */
            ByteSource salt = ByteSource.Util.bytes(user.getUsername());
            String passwordSalt= new SimpleHash("MD5", user.getPassword(), salt, 1024).toHex();
            user.setPassword(passwordSalt);

            //密码认证由shiro自动完成
            //此处的密码一定是数据库中的密码
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), salt,getName());
            return info;
        }
    }

