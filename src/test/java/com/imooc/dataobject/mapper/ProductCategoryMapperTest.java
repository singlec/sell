package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("categoryName", "夏日特饮");
        map.put("categoryType", 4);
        int i = mapper.insertByMap(map);
        assertEquals(1, i);

    }

    @Test
    public void updateByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(4);
        productCategory.setCategoryName("异域风情");
        productCategory.setCategoryType(14);
        int i = mapper.updateByObject(productCategory);
        assertEquals(1,i);
    }

    @Test
    public void list() {
        List<ProductCategory> list = mapper.list();
        assertTrue(list.size()>0);
    }

    @Test
    public void findById() {
        ProductCategory productCategory = mapper.findById(1);
        assertNotNull(productCategory);
    }

    @Test
    public void selectByCategoryType() {
        ProductCategory productCategory = mapper.selectByCategoryType(2);
        assertNotNull(productCategory);
    }
}