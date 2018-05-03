package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRespositoryTest {

    @Autowired
    private OrderMasterRepository respository;
    private static final String OPENID ="abc123";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();

        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderId("123");
        orderMaster.setBuyerAddress("南京");
        orderMaster.setBuyerName("ccl");
        orderMaster.setBuyerPhone("132");
        orderMaster.setOrderAmount(new BigDecimal(333));

        OrderMaster save = respository.save(orderMaster);
        assertNotNull(save);
    }
    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = PageRequest.of(1, 2);
        Page<OrderMaster> page = respository.findByBuyerOpenid(OPENID, pageRequest);
        System.out.println(page.getTotalElements());
    }
}