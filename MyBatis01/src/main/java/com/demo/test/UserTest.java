package com.demo.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 任何一个框架都有一个核心的配置文件，在使用这个框架的时候，
 * 首先需要找到这个框架的核心类（或接口），
 * 然后通过这个核心类（或接口）去与框架的核心配置文件关联。
 * mybatis 的核心对象：SqlSessionFactory
 */
public class UserTest {
    public static void main(String[] args) throws IOException {
        // 通过输入流与 mybatis 的核心配置文件关联
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        // 用于构建出 mybatis 的核心对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // mybatis 的核心对象，用于去构建操作数据库的对象
        SqlSessionFactory factory = builder.build(in);
        // 通过核心对象获取到 sql 的会话对象
        SqlSession sqlSession = factory.openSession();
        // 调用查询语句，需要与对应的 mapper 文件（sql文件）具体的哪个sql标签进行关联
        Object obj = sqlSession.selectOne("abc.selectUserById",1);
        // 打印通过 sql 语句在数据库中查询出的对象
        System.out.println(obj);
    }
}
