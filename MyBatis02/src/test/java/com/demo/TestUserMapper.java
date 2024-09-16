package com.demo;

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
import java.util.*;

public class TestUserMapper {
    private UserMapper userMapper;
    private SqlSession sqlSession;
    private SqlSessionFactory factory;

    @BeforeEach
    public void init() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        sqlSession = factory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testSelectUser(){
        List<User> users = userMapper.selectUser("李", 25, 1);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectUser2(){
        Map<String, Object> map =new HashMap<>();
        map.put("name","李");
        map.put("age",28);
        map.put("sex",1);
        List<User> users = userMapper.selectUser2(map);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectUserById(){
        User user = userMapper.selectUserById(5);
        System.out.println(user);
    }

    @Test
    public void testSelectAll(){
        List<User> users = userMapper.selectAll();
        users.forEach(System.out::println);
    }

    @Test
    public void testDynamicUser(){
        Map<String, Object> map =new HashMap<>();
        map.put("age",28);
        map.put("sex",1);
        List<User> users = userMapper.dynamicUser(map);
        users.forEach(System.out::println);
    }

    @Test
    public void testUpdateUser(){
        Map<String, Object> map =new HashMap<>();
        map.put("name","张三");
        map.put("age",33);
        map.put("sex",2);
        map.put("id",1);
        Integer i = userMapper.updateUser(map);
        System.out.println(i);
    }

    @Test
    public void testFindIds(){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6);
        List<User> ids = userMapper.findIds(list);
        ids.forEach(System.out::println);
    }

    @Test
    public void testChooseUser(){
        Map<String, Object> map =new HashMap<>();
        //map.put("name","张三");
        map.put("age",28);
        //map.put("sex",2);
        //map.put("id",6);
        List<User> users = userMapper.chooseUser(map);
        users.forEach(System.out::println);
    }

    /**
     * 缓存：将数据临时存储在内存中，而不是频繁的去读取数据库数据。数据优化的一种策略。
     * mybatis的缓存分为两种：一级缓存（默认开启）、二级缓存。
     * 1. mybatis 默认是开启一级缓存。当使用 openSession 方法之后，获取到 SqlSession 对象，
     *    使用当前这个 SqlSession 对象进行数据库的操作，第一次会真正的发出sql请求，从数据库获取数据，
     *    查询到之后，将数据临时进行存储（缓存），后续再使用当前 sqlSession 时，
     *    继续查询相同的数据，这时会走缓存，而不会执行新的 sql 查询操作。
     *    可以通过在select标签上设置flushCache="false"属性为true，要求每次的查询，都必须刷新缓存（每次都应该执行sql查询数据）
     * 2. 二级缓存：需要在 mapper 配置文件中使用`<cache />` 配置，才能开启二级缓存。
     *      <cache eviction="FIFO" lushInterval="60000" size="512" readOnly="true"/>
     *      eviction 属性：配置数据存取的方式 FIFO（先进先出）
     *      flushInterval 属性：数据刷新周期
     *      size 属性：最多可以存储512个对象
     *      readOnly 属性：缓存中的数据不可修改，只能读取
     */
    // 使用同一个 SqlSession 对象，查询两次相同数据，只执行一次 sql 语句，清除缓存后，执行两次 sql 语句。
    @Test
    public void testCache(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.selectUserById(4);
        System.out.println(user1);
        // 清除缓存
        //sqlSession.clearCache();
        // 关闭 SqlSession 对象
        //sqlSession.close();
        User user2 = mapper.selectUserById(4);
        System.out.println(user2);
    }
}
