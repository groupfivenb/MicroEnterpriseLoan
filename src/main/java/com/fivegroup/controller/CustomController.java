package com.fivegroup.controller;

import com.fivegroup.service.CustomService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/*@ClassName:CustomController
 *@Author:陈昊
 *@Date:Created in 11:10
 *@Version 1.0
 */
@Controller
@RequestMapping("/custom")
public class CustomController {
    @Autowired
    private CustomService service;

    @RequestMapping("/login")
    @ResponseBody
    public Object login(@RequestBody Map map){
        String username=map.get("username")+"";
        String password=map.get("password")+"";
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        Subject subject= SecurityUtils.getSubject();
        String msg= null;
            msg = "suc";
        try {
            subject.login(token);
        } catch (Exception e) {
            System.out.println("陈昊"+e.getClass().getName());
            e.printStackTrace();
            token.clear();
            if (UnknownAccountException.class.getName().equals(e.getClass().getName())){
                msg="zhcw";
            }
            else if (IncorrectCredentialsException.class.getName().equals(e.getClass().getName())){
                msg="mmcw";
            }
        }
        Map resMap=new HashMap();
        resMap.put("msg",msg);
        resMap.put("custom",service.findByUsername(username));
        return resMap;
    }
    @RequestMapping("/reg")
    @ResponseBody
    public Object reg(@RequestBody Map map){
        if (map.get("username")==""||map.get("password")==""||map.get("age")==""||map.get("name")==""){
            return -1;
        }
            return service.reg(map);
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public Object page(@RequestBody Map map) {
        Map resMap=new HashMap();
        resMap.put("total",service.findAllCount(map));
        resMap.put("customList",service.findAll(map));
            return resMap;
    }
    @RequestMapping("/testf")
    public String testf(){
        return "abc";
    }
}
