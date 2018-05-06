package com.imooc.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

/**
 * Create By 一条狗
 * 2018/5/4 21:41
 */
@Data
public class ProductForm {

    private String productId;

    /** 商品名称 */
    @NotEmpty(message = "商品名称不能为空")
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

}
