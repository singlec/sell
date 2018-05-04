package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory one = categoryService.findOne(1);
        System.out.println(one);
    }

    @Test
    public void findAll() {
        List<ProductCategory> all = categoryService.findAll();
        System.out.println(all);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(1, 3));
        System.out.println(list);
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(3);
        productCategory.setCategoryName("特色烧烤");
        productCategory.setCategoryType(7);
//        ProductCategory productCategory = categoryService.findOne(3);
        ProductCategory save = categoryService.save(productCategory);
        System.out.println(save);
    }
}