package com.demo;

import com.demo.dao.UserDao;
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

public class TestUserDao {
    /**
     * junit4 和 junit5 中注解的变化:
     *
     * junit4       junit5
     *
     * @Before === @BeforeEach  在每次执行 @Test 之前都会先执行这个注解的方法
     * @After  === @AfterEach   在每次执行 @Test 之后都会执行这个注解的方法
     *
     * @BeforeClass === @BeforeAll  在任何 @Test 执行之前，在类加载的时候，执行这个注解的方法
     * @AfterClass  === @AfterAll   在任何 @Test 执行之后，程序结束之前，执行这个注解的方法
     */
    private UserDao userDao;
    @BeforeEach
    public void fn() throws IOException{
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        /**
         * mybatis 框架在进行添加，修改，删除的时候，默认事务是不提交的。
         * 控制台日志打印：Setting autocommit to false on JDBC Connection
         * 需要在获取 SqlSession 对象的时候，强制将事务设置为自动提交。
         * factory.openSession(true);   事务设置为自动提交
         * factory.openSession(false);  事务设置为手动提交
         */
        SqlSession sqlSession = factory.openSession(true);
        userDao = new UserDao(sqlSession);
    }

    @Test
    public void testAdduser() throws IOException{
        User user = new User();
        user.setUserName("四哥");
        user.setPassword("123123");
        user.setName("赵四");
        user.setAge(20);
        user.setSex(1);
        Integer x = userDao.addUser(user);
        System.out.println(x);
    }


    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setName("赵四四");
        user.setAge(30);
        user.setSex(0);
        user.setBirthday(new Date());
        user.setId(8L);
        Integer x = userDao.updateUser(user);
        System.out.println(x);
    }


    @Test
    public void testDeleteUser(){
        Integer x = userDao.deleteUser(9);
        System.out.println(x);
    }

    @Test
    public void testFindUserById(){
        User user = userDao.selectUserById(3);
        System.out.println(user);
    }

    @Test
    public void testFindAllUser(){
        List<User> list = userDao.selectAll();
        list.forEach(System.out::println);

    }
}
