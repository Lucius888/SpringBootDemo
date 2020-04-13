/**
 * Copyright (C), Lucius
 * FileName: ShiroConfig
 * Author:
 * Date:     2020/4/12 12:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lucius.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        /*
            anon: 无需认证就可以访问
            authc： 需要认证才能够访问

         */

        //设置未认证(登录)时，访问需要认证的资源时跳转的页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
//
//        // 登录成功后跳转的url
//        shiroFilterFactoryBean.setSuccessUrl("/userList");
//
//        //设置访问无权限的资源时跳转的页面
//        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
//
        //指定路径和过滤器的对应关系
        Map<String, String> filterMap = new LinkedHashMap<>();

        // 定义filterChain，静态资源不拦截
        // 配置不会被拦截的链接 顺序判断  相关静态资源
        filterMap.put("/static/**", "anon");
        filterMap.put("/css/**", "anon");
        filterMap.put("/font/**", "anon");
        filterMap.put("/images/**", "anon");
        filterMap.put("/js/**", "anon");

        // user下的所有都必须要认证才能够访问
        filterMap.put("/user/*","authc");
        // druid数据源监控页面不拦截
        filterMap.put("/druid/**", "anon");
        // 配置退出过滤器，其中具体的退出代码Shiro已经替我们实现了
        filterMap.put("/logout", "logout");

//        //其他路径则需要登录才能访问
//        filterMap.put("/**", "authc");
//
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    //安全管理器配置
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("shiroRealm") ShiroRealm shiroRealm) {
        // 配置SecurityManager，
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        // 注入shiroRealm
        defaultWebSecurityManager.setRealm(shiroRealm);
        return defaultWebSecurityManager;
    }

    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();

        //使用HashedCredentialsMatcher带加密的匹配器来替换原先明文密码匹配器
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //指定加密算法
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        //指定加密次数
        hashedCredentialsMatcher.setHashIterations(1024);
        // 生成16进制, 与注册时的生成格式相同
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);

        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher);

        return shiroRealm;
    }
}
