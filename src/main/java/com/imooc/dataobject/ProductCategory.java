package com.imooc.dataobject;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Create By 一条狗
 * 2018/4/14 11:03
 */
@Table(name = "product_category")
@Entity
@Data
public class ProductCategory {
    /** 类目id */
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 类目名字 */
    private String categoryName;

    /** 类目编号 */
    private Integer categoryType;

    public ProductCategory() {
    }
}
