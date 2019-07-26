package com.fivegroup.util;/*@ClassName
 *@Author:陈昊
 *@Date:Created in 8:52
 *@Version $
 */

import com.fivegroup.entity.Custom;
import com.fivegroup.service.CustomService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class Myrealm extends AuthorizingRealm {
@Autowired
    private CustomService service;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权!");
        Subject subject = SecurityUtils.getSubject();
        Custom custom = (Custom) subject.getPrincipal();
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证!");
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        String username=token.getUsername();
        Custom custom=service.findByUsername(username);
        if (custom!=null){
            return new SimpleAuthenticationInfo(custom,custom.getPassword(),getName());
        }
        return null;
    }
}
