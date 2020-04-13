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
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
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
            System.out.println("执行了授权");
            SimpleAuthorizationInfo info =new SimpleAuthorizationInfo();
            //获取当前登录对象
            Subject subject = SecurityUtils.getSubject();
            //拿到当前用户
            User currentUser = (User) subject.getPrincipal();

//           这段代码展示了多个用户多个角色多个全权限的操作方法
//            for (Role role : userInfo.getRoleList()) {
//                // 分配角色
//                authorizationInfo.addRole(role.getRole());
//                for (Permission p : role.getPermissions()) {
//                    // 分配权限
//                    authorizationInfo.addStringPermission(p.getPermission());
//                }
//            }
            //获取当前用户权限
            info.addStringPermission(currentUser.getPermission());

            return info;
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

