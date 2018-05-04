package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品信息
 * Create By 一条狗
 * 2018/4/14 23:46
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {
    @Id
    private String productId;

    /** 商品名称 */
    private String productName;

    /** 单价 */
    private BigDecimal productPrice;

    /** 库存 */
    private Integer productStock;

    /** 描述 */
    private String productDescription;

    /** 小图 */
    private String productIcon;

    /** 商品类目 */
    private Integer categoryType;

    /** 商品状态,0正常 1下架. */
    private Integer productStatus;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;
}
