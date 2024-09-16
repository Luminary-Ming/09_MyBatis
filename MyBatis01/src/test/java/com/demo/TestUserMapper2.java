package com.demo;

import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestUserMapper2 {
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
    public void testFindUserById(){
        User user = userMapper.selectUserById(6);
        System.out.println(user);
    }
    @Test
    public void testFindAllUser(){
        List<User> list = userMapper.selectAll();
        list.forEach(System.out::println);

    }
}
