package com.imooc.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 类目表单
 * Create By 一条狗
 * 2018/5/5 12:33
 */
@Data
public class CategoryForm {

    /** 类目id */
    private Integer categoryId;

    /** 类目名称 */
    @NotEmpty(message = "类目名称不能为空")
    private String categoryName;

    /** 类目类型 */
    private Integer categoryType;

}
