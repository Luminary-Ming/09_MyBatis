package com.demo.pojo;

import lombok.Data;

import java.util.Date;

/**
 * lombok (插件 + 依赖) ：可以帮助快速生成类对应的构造方法、getter方法、setter方法、equals 和 hashCode 方法等。
 * @Getter  自动生成字段的 getter 方法
 * @Setter  自动生成字段的 setter 方法
 * @ToString  自动生成 toString 方法
 * @EqualsAndHashCode  自动生成 equals 和 hashCode 方法
 * @NoArgsConstructor  自动生成无参构造函数
 * @AllArgsConstrutor  自动生成包含所有字段的构造函数
 * @Data  组合了 @Getter、@Setter、@ToString、@EqualsAndHashCode、@NoArgsConstructor 注解的功能
 */
@Data
public class User {
    private Long Id;
    // 用户名
    private String userName;
    // 密码
    private String password;
    // 姓名
    private String name;
    // 年龄
    private Integer age;
    // 性别
    private Integer sex;
    // 生日
    private Date birthday;
    // 创建时间
    private Date created;
    // 更新时间
    private Date updated;


}
