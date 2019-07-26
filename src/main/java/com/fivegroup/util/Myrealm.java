package com.fivegroup.util;/*@ClassName
 *@Author:陈昊
 *@Date:Created in 8:52
 *@Version $
 */

import com.fivegroup.entity.User2;
import com.fivegroup.service.User2Service;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class Myrealm extends AuthorizingRealm {
@Autowired
    private User2Service service;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权!");
        Subject subject = SecurityUtils.getSubject();
        User2 user = (User2) subject.getPrincipal();
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证!");
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        User2 user=service.findByName(token.getUsername());
        if (user!=null){
            return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        }
        return null;
    }
}
