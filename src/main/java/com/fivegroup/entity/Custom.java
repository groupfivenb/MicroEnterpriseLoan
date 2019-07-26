package com.fivegroup.entity;

import lombok.Data;

/*@ClassName:Custom
 *@Author:陈昊
 *@Date:Created in 11:08
 *@Version 1.0
 */
@Data
public class Custom {
    private int id;
    private int age;
    private String name ;
    private String username;
    private  String password;

    public Custom(int age, String name, String username, String password) {
        this.age = age;
        this.name = name;
        this.username = username;
        this.password = password;
    }
}
