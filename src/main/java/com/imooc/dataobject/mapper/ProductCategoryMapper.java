package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * mybatis注解方式的使用
 */
public interface ProductCategoryMapper {

    @Insert("insert into product_category(category_name,category_type) values (#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByMap(Map<String ,Object> map);

    @Update("update product_category set category_name=#{categoryName,jdbcType=VARCHAR},category_type=#{categoryType,jdbcType=INTEGER} " +
            "where category_id=#{categoryId,jdbcType=INTEGER}")
    int updateByObject(ProductCategory productCategory);

    @Select({"select * from product_category"})
    @Results({
        @Result(column = "category_id",property = "categoryId"),
        @Result(column = "category_name",property = "categoryName")
    })
    List<ProductCategory> list();

    @Select("select category_name categoryName from product_category where category_id=#{categoryId}")
    ProductCategory findById(@Param("categoryId") Integer categoryId);

    ProductCategory selectByCategoryType(Integer categoryType);
}
