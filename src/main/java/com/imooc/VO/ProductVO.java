package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Create By 一条狗
 * 2018/4/15 18:35
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    private String categroyName;

    @JsonProperty("type")
    private Integer categroyType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
