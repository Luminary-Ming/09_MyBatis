package com.demo.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 用户表
 */
@Data
public class User {
    private Long id;
    // 用户名 user_name
    private String userName;
    // 密码
    private String password;
    // 姓名
    private String name;
    // 年龄
    private Integer age;
    // 性别  1 男性，2 女性
    private Integer sex;
    // 出生日期
    private Date birthday;
    // 创建时间
    private Date created;
    // 更新时间
    private Date updated;
}
