package com.imooc.enums;

import lombok.Getter;

/**
 * Create By 一条狗
 * 2018/4/21 13:17
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(1, "参数不正确"),
    PRODUCT_NOT_EXIT(10, "商品信息不存在"),
    PRODUCT_STORE_ERROR(11, "商品库存不足"),
    ORDERDETAIL_NOT_EXIT(12, "商品详情不存在"),
    ORDER_STATUS_ERROR(13, "订单状态不正确"),
    ORDER_UPDATE_FAIL(14, "订单状态修改失败"),
    ORDER_DETAIL_EMPTY(16, "订单详情为空"),
    PAY_STATUS_ERROR(17, "订单支付状态不正确"),
    CART_EMPTY_ERROR(18,"购物车为空"),
    ORDER_OWNER_ERROR(19,"该订单不属于当前用户" ),
    ORDER_NOT_EXIT(20,"订单不存在" );
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
