package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.service.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl service;

    @Test
    public void findOne() {
        ProductInfo one = service.findOne("123456");
        assertEquals(one.getProductId(),"123456");
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = service.findUpAll();
        Assert.assertNotEquals(0,upAll.size());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<ProductInfo> all = service.findAll(pageRequest);
        System.out.println(all.getContent());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("111333");
        productInfo.setCategoryType(2);
        productInfo.setProductName("口水鸡");
        productInfo.setProductPrice(new BigDecimal(23.6));
        productInfo.setProductDescription("本店招牌");
        productInfo.setProductStatus(0);
        productInfo.setProductIcon("http://123.boboji.com");
        productInfo.setProductStock(100);
        ProductInfo saved = service.save(productInfo);
        assertEquals(saved.getProductId(),"111333");
    }
}