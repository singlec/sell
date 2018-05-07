package com.imooc.dataobject.dao;

import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCategoryDao {

    @Autowired
    private ProductCategoryMapper mapper;

    public ProductCategory findById(Integer categoryId) {
        return mapper.findById(categoryId);
    }
}
