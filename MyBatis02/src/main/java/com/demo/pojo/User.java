package com.demo.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private Long Id;
    // 用户名 user_name
    private String userName;
    // 密码
    private String password;
    // 姓名
    private String name;
    // 年龄
    private Integer age;
    // 性别 1 男，2 女
    private Integer sex;
    // 生日
    private Date birthday;
    // 创建时间
    private Date created;
    // 更新时间
    private Date updated;
}
