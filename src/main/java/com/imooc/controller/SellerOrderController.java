package com.imooc.controller;

import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Create By 一条狗
 * 2018/4/27 23:32
 */
@Controller
@RequestMapping("/seller/order")
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(name = "page",defaultValue = "1") int page,
                                   @RequestParam(name = "size",defaultValue = "3") int size,
                                   Map<String,Object> map) {
        PageRequest pageRequest = PageRequest.of(page-1, size);

        Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("order/list", map);
    }

    /**
     * 订单详情
     * @param orderId 订单id
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam(name = "orderId") String orderId,
                                   Map<String,Object> map) {
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            map.put("orderDTO", orderDTO);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        return new ModelAndView("order/detail", map);
    }

    /**
     * 取消订单
     * @param orderId 订单id
     */
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam(name = "orderId") String orderId,
                                   Map<String,Object> map) {
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        } catch (SellException e) {
            map.put("url", "/sell/seller/order/list");
            map.put("msg", e.getMessage());
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/order/list");
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());

        return new ModelAndView("common/success", map);
    }
    /**
     * 完成订单
     * @param orderId 订单id
     */
    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam(name = "orderId") String orderId,
                                   Map<String,Object> map) {
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        } catch (SellException e) {
            map.put("url", "/sell/seller/order/list");
            map.put("msg", e.getMessage());
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/order/list");
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());

        return new ModelAndView("common/success", map);
    }
}
