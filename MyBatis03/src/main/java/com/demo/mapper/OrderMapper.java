package com.demo.mapper;

import com.demo.pojo.Order;

import java.util.List;

public interface OrderMapper {
    /**
     * 根据订单的 id 查询订单和对应的用户数据
     * （一对一，一个订单对应一个用户）
     * tb_order表 和 tb_user表 联查
     */
    public Order orderAndUser(Integer id);

    /**
     * 通过订单的 id，查询订单的数据，同时查询订单的明细数据
     * （一对多，一个订单对应多个订单明细数据）
     * 比如一个订单里购买了一个手机，一台电脑，一本书，那么对应的就有三个订单明细数据
     * tb_order表 和 tb_orderdetail表 联查
     */
    public Order orderAndOrderDetail(Integer id);

    /**
     * 通过订单的 id 查询订单的数据，并查询出对应的商品数据
     * （多对多，一个订单对应多个商品，一个商品对应多个订单）
     * tb_order表 和 tb_orderdetail表 和 tb_item表 联查
     * 先通过订单查询到对应的订单明细，明细查询到关联的商品
     */
    public Order orderAndItem(Integer id);
}
