package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Create By 一条狗
 * 2018/4/15 11:48
 */
public interface ProductRepository extends JpaRepository<ProductInfo,String >{
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
