package com.fivegroup.dao;

import com.fivegroup.entity.Custom;

import java.util.List;
import java.util.Map;

public interface CustomDao {
    List<Custom> login(Map map);
    Custom findByUsername(String username);
    int reg(Map map);
    List<Custom> findAll(Map map);
    int findAllCount(Map map);
}
