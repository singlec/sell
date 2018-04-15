package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
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
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> all = repository.findAll();
        System.out.println(all);
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("13326");
        productInfo.setCategoryType(2);
        productInfo.setProductName("红烧肉");
        productInfo.setProductPrice(new BigDecimal(22.5));
        productInfo.setProductDescription("好吃又长肉");
        productInfo.setProductStatus(0);
        productInfo.setProductIcon("http://123.123.123.com");
        productInfo.setProductStock(20);
        ProductInfo saved = repository.save(productInfo);
        assertEquals(saved.getProductId(),"13326");
    }

    @Test
    public void findProductInfoByProductStatus() {
        List<ProductInfo> productInfos = repository.findByProductStatus(0);
        System.out.println(productInfos);
    }
}