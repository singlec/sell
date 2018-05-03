package com.imooc.service;

import com.imooc.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Create By 一条狗
 * 2018/4/21 11:41
 */
public interface OrderService {

    /** 创建订单 */
    OrderDTO create(OrderDTO orderDTO);

    /** 查看订单 */
    OrderDTO findOne(String orderId);

    /** 查看订单列表 */
    Page<OrderDTO> findList(String buyerOpenid,Pageable pageable);

    /** 取消订单 */
    OrderDTO cancel(OrderDTO orderDTO);

    /** 完结订单 */
    OrderDTO finish(OrderDTO orderDTO);

    /** 支付订单*/
    OrderDTO paid(OrderDTO orderDTO);

    /** 查看订单列表 */
    Page<OrderDTO> findList(Pageable pageable);

}
