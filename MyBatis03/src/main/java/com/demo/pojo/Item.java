package com.demo.pojo;

import lombok.Data;

/**
 * 商品表
 */
@Data
public class Item{
    // 商品 id
    private Integer id;
    // 商品名称
    private String itemName;
    // 商品价格
    private Float itemPrice;
    // 商品描述
    private String itemDetail;
}
