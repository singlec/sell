package com.imooc.dto;

import lombok.Data;

/**
 * Create By 一条狗
 * 2018/4/21 16:02
 */
@Data
public class CartDTO {

    /** 商品id */
    private String productId;

    /** 商品数量 */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
