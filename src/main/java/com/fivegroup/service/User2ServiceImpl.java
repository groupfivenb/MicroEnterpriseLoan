package com.aaa.fivegroup.demo.service;/*@ClassName
 *@Author:陈昊
 *@Date:Created in 9:39
 *@Version $
 */

import com.aaa.fivegroup.demo.dao.User2Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class User2ServiceImpl implements User2Service {
    @Resource
    private User2Dao dao;
    @Override
    public List findAll() {
        System.out.println(dao.findAll());
        return dao.findAll();
    }
}
