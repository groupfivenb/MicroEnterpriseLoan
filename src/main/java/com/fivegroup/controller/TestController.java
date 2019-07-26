package com.fivegroup.controller;/*@ClassName
 *@Author:陈昊
 *@Date:Created in 21:46
 *@Version $
 */

import com.fivegroup.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/demo")
public class TestController {
    @Autowired
    private User2Service service;
    @GetMapping("/test1")
    @ResponseBody
    public String test1(){
        return "hello world!";
    }
    @GetMapping("/test2")
    public List test2(){
        return service.findAll();
    }
}
