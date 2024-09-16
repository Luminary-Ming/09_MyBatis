package com.demo.pojo;

import lombok.Data;

/**
 * 订单明细
 */
@Data
public class OrderDetail {
    // 订单明细 id
    private Integer id;
    // 订单 id
    private Integer orderId;
    // 商品 id
    private Integer itemId;
    // 商品总价
    private Double totalPrice;
    // 状态
    private Integer status;
    /**
     * 一个订单明细对应一个商品
     */
    private Item item;
}
