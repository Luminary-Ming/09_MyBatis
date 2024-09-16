package com.demo.mapper;

import com.demo.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * MyBatis 使用 注解 方式开发
 */
public interface UserMapper2 {
    /**
     * 查询所有用户信息
     */
    @Select("select * from tb_user")
    public List<User> selectAll();

    /**
     * 根据 id 查询用户信息
     */
    @Select("select * from tb_user where id = #{id}")
    public User selectUserById(Integer id);

    /**
     * 根据 id 删除用户信息
     */
    @Delete("delete from tb_user where id = #{id}")
    public Integer deleteUserById(Integer id);

    /**
     * 添加用户信息
     */
    @Insert("insert into tb_user(user_name ,password,name)) values(null , #{username},#{password} ,#{name})")
    public Integer addUser(User user);

    /**
     * 修改用户信息
     */
    @Update("update tb_user set name=#{name},password = #{password} where id = #{id}")
    public Integer updateUser(User user);
}
