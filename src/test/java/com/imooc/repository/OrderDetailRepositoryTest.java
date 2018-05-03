package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("acc124");
        orderDetail.setOrderId("123");
        orderDetail.setProductIcon("http://xxxx");
        orderDetail.setProductName("哈密瓜");
        orderDetail.setProductPrice(new BigDecimal(12.5));
        orderDetail.setProductQuantity(100);
        orderDetail.setProductId("112");

        OrderDetail save = repository.save(orderDetail);
        assertNotNull(save);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> details = repository.findByOrderId("123");
        System.out.println(details);
    }
}