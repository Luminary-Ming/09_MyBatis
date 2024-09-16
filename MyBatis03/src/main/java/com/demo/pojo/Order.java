package com.demo.pojo;

import lombok.Data;

import java.util.List;

/**
 * 订单表
 */
@Data
public class Order {
    // 订单 id
    private Integer id;
    // 用户 id
    private Long userId;
    // 订单编号
    private String orderNumber;

    /**
     * 一个订单对应一个用户
     */
    private User user;

    /**
     * 一个订单对应多个明细
     */
    private List<OrderDetail> orderDetails;

}
