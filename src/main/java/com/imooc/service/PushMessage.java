package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * 推送消息
 */
public interface PushMessage {

    /**
     * 订单状态变更
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);

}
