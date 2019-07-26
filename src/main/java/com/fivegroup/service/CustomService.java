package com.fivegroup.service;

import com.fivegroup.entity.Custom;

import java.util.List;
import java.util.Map;

public interface CustomService {
    List<Custom> login(Map map);
    Custom findByUsername(String username);
    int reg(Map map);
    List<Custom> findAll(Map map);
    int findAllCount(Map map);
}
