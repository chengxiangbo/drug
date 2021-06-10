package com.valueplus.drug.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 前线控制Shiro配置类
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建过滤工厂Bean
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        /**
         * shiro内置的过滤器，实现权限相关的拦截器
         * anon：不需要什么权限就可以访问的，不用登录
         * authc:必须的呢公路才能访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/static/**","anon");
        filterMap.put("/login","anon");
        filterMap.put("/toLogin","anon");
        filterMap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        //不登录自动转向的页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //登录后自动转向的页面
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //没有权限时自动跳转的页面
//        shiroFilterFactoryBean.setUnauthorizedUrl("/");
        return shiroFilterFactoryBean;
    }

    /**
     * 安全权限管理
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    /**
     * 创建realm，认证用
     * @return
     */
    @Bean
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

    /**
     * thymeleaf整合Shiro
     */
    @Bean
    public ShiroDialect shiroDialect(){
        ShiroDialect shiroDialect = new ShiroDialect();
        return shiroDialect;
    }

}
