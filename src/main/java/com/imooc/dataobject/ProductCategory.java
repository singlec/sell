package com.imooc.dataobject;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Create By 一条狗
 * 2018/4/14 11:03
 */
//@Table(name = "product_category")
@Entity
@Data
//@DynamicUpdate
public class ProductCategory {
    /** 类目id */
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 类目名字 */
    private String categoryName;

    /** 类目编号 */
    private Integer categoryType;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    public ProductCategory() {
    }
}
