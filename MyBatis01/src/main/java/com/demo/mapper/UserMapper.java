package com.demo.mapper;

import com.demo.pojo.User;

import java.util.List;

/**
 *  MyBatis 使用 XML 映射文件方式开发
 */
public interface UserMapper {
    /**
     * 查询所有用户信息
     */
    public List<User> selectAll();

    /**
     * 根据 id 查询用户信息
     */
    public User selectUserById(Integer id);

    /**
     * 根据 id 删除用户信息
     */
    public Integer deleteUserById(Integer id);

    /**
     * 添加用户信息
     */
    public Integer addUser(User user);

    /**
     * 修改用户信息
     */
    public Integer updateUser(User user);
}
