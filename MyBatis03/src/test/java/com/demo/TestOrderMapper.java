package com.demo;

import com.demo.mapper.OrderMapper;
import com.demo.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestOrderMapper {
    private OrderMapper orderMapper;
    @BeforeEach
    public void init() throws IOException{
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession(true);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void testOrderAndUser(){
        Order order = orderMapper.orderAndUser(1);
        System.out.println(order);
    }

    @Test
    public void testOrderAndOrderDetail(){
        Order order = orderMapper.orderAndOrderDetail(1);
        System.out.println(order);
    }

    @Test
    public void testOrderAndItem(){
        Order order = orderMapper.orderAndItem(1);
        System.out.println(order);
    }
}
