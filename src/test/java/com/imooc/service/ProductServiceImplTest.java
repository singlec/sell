package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
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
        ProductInfo one = service.findOne("1");
        assertEquals(one.getProductId(),"1");
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
        productInfo.setProductId("112");
        productInfo.setCategoryType(2);
        productInfo.setProductName("咸鸭蛋");
        productInfo.setProductPrice(new BigDecimal(1.5));
        productInfo.setProductDescription("端午来了");
        productInfo.setProductStatus(0);
        productInfo.setProductIcon("http://123.xianyadan.com");
        productInfo.setProductStock(1000);
        ProductInfo saved = service.save(productInfo);
        assertEquals(saved.getProductId(),"112");
    }
}