package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findById(1).get();
        System.out.println(productCategory);
    }
    @Test
    public void findByCategoryTypeIn() {
        List<Integer> categoryTypeList = Arrays.asList(1, 3);
        List<ProductCategory> productCategoryList = repository.findByCategoryTypeIn(categoryTypeList );
//        System.out.println(productCategoryList);
        Assert.assertEquals(2,productCategoryList.size());
    }
    @Test
    @Transactional
    public void saveTest() {
//        ProductCategory productCategory = repository.findById(1).get();
        ProductCategory pc = new ProductCategory();
        pc.setCategoryId(4);
        pc.setCategoryName("爆款");
        pc.setCategoryType(5);
//        productCategory.setCategoryName("人人必备");
        repository.save(pc);
    }

}