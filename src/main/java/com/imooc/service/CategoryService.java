package com.imooc.service;

import com.imooc.dataobject.ProductCategory;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 类目
 * Create By 一条狗
 * 2018/4/14 13:02
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryList);
    ProductCategory save(ProductCategory productCategory);
}
