package com.fivegroup.util;/*@ClassName
 *@Author:陈昊
 *@Date:Created in 8:51
 *@Version $
 */

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean(value = "getRealm")
    public Myrealm getRealm(){
        return new Myrealm();
    }

    @Bean(value = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier(value = "getSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        //配置默认安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        // 设置登录成功跳转Url
        bean.setSuccessUrl("/boot/templates/login/menu.html");
        // 设置登录跳转Url
        bean.setLoginUrl("/boot/static/start.html");
        // 设置未授权提示Url+
        //bean.setUnauthorizedUrl("/boot/templates/login/error.html");

        /**
         * anon：匿名用户可访问
         * authc：认证用户可访问
         * user：使用rememberMe可访问
         * perms：对应权限可访问
         * role：对应角色权限可访问
         **/
        Map<String,String>filterMap=new LinkedHashMap<>();

        filterMap.put("/custom/logout","logout");
        filterMap.put("/test/*","authc");
        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }
    /**
     * 注入 securityManager
     */
    @Bean(value = "getSecurityManager")
    public DefaultWebSecurityManager getSecurityManager(@Qualifier(value = "getRealm")Myrealm myrealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(myrealm);
        return securityManager;
    }

}
