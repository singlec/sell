package com.imooc.service;

import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create By 一条狗
 * 2018/4/25 0:03
 */
@Slf4j
@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        OrderDTO orderDTO = validateOwner(openid, orderId);

        return orderDTO;
    }


    @Override
    public void cancel(String openid, String orderId) {
        OrderDTO orderDTO = validateOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("[取消订单]查不到该订单,orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIT);
        }
        orderService.cancel(orderDTO);
    }

    //验证订单所属
    private OrderDTO validateOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO==null) {
            return null;
        }
        if (!orderDTO.getBuyerOpenid().equals(openid)) {
            log.error("[查询一个订单]订单openid不一致,openid={},orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }

        return orderDTO;
    }
}
