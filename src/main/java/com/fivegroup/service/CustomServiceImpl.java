package com.fivegroup.service;

import com.fivegroup.dao.CustomDao;
import com.fivegroup.entity.Custom;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/*@ClassName:CustomServiceImpl
 *@Author:陈昊
 *@Date:Created in 11:09
 *@Version 1.0
 */
@Service
public class CustomServiceImpl
        implements CustomService {
    @Resource
    private CustomDao dao;

    @Override
    public List<Custom> login(Map map) {
        return dao.login(map);
    }

    @Override
    public Custom findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public int reg(Map map) {
        return dao.reg(map);
    }

    @Override
    public List<Custom> findAll(Map map) {
        return dao.findAll(map);
    }

    @Override
    public int findAllCount(Map map) {
        return dao.findAllCount(map);
    }
}
