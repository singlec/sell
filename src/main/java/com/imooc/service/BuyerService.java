package com.imooc.service;

import com.imooc.dto.OrderDTO;
import org.springframework.stereotype.Service;

/**
 * Create By 一条狗
 * 2018/4/25 0:00
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    void cancel(String openid, String orderId);
}
