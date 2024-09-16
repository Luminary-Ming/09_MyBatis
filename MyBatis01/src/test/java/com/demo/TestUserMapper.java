package com.demo;

import com.demo.dao.UserDao;
import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestUserMapper {
    private UserMapper userMapper;
    @BeforeEach
    public void fn() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession(true);
        // 通过 sqlSession 对象，去获取 mybatis 基于接口而产生的代理对象
        userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper);
    }

    @Test
    public void testAdduser() throws IOException {
        User user = new User();
        user.setUserName("四哥");
        user.setPassword("123123");
        user.setName("赵四");
        user.setAge(20);
        user.setSex(1);
        Integer x = userMapper.addUser(user);
        System.out.println(x);
    }


    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setName("赵四四");
        user.setAge(30);
        user.setSex(0);
        user.setBirthday(new Date());
        user.setId(8L);
        Integer x = userMapper.updateUser(user);
        System.out.println(x);
    }


    @Test
    public void testDeleteUser() {
        Integer x = userMapper.deleteUserById(9);
        System.out.println(x);
    }

    @Test
    public void testFindUserById() {
        User user = userMapper.selectUserById(3);
        System.out.println(user);
    }

    @Test
    public void testFindAllUser() {
        List<User> list = userMapper.selectAll();
        list.forEach(System.out::println);

    }


}
