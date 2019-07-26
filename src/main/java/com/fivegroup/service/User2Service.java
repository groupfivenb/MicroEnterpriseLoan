package com.fivegroup.service;/*@ClassName
 *@Author:陈昊
 *@Date:Created in 9:39
 *@Version $
 */

import com.fivegroup.entity.User2;

import java.util.List;

public interface User2Service {
    List findAll();
    User2 findByName(String name);
}
