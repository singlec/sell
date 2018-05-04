package com.imooc.service.impl;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import com.imooc.service.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    private static final String BUYER_OPENID = "abcdefg123";
    private static final String ORDERID = "1525403690220449321";

    @Test
    public void create() {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("杭州余杭区金家渡");
        orderDTO.setBuyerName("ccl");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        orderDTO.setBuyerPhone("1234567890098");
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123456");
        orderDetail.setProductQuantity(2);
        orderDetailList.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO one = orderService.findOne(ORDERID);
        Assert.assertNotNull(one);
    }

    @Test
    public void findList() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<OrderDTO> page = orderService.findList(ORDERID, pageRequest);
        Assert.assertNotEquals(0,page.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDERID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(ORDERID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(ORDERID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }

    @Test
    public void all() {
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);
        Assert.assertTrue("查询所有订单列表",orderDTOPage.getTotalElements()>0);
        Assert.assertNotNull(orderDTOPage.getContent());
    }
}