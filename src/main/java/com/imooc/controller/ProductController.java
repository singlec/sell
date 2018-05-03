package com.imooc.controller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品
 * Create By 一条狗
 * 2018/4/15 18:32
 */
@RestController
@RequestMapping("/buyer/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("list")
    public ResultVO list() {

        //1. 查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. 查询类目(一次性查询)
        //传统方法
//          ArrayList<Integer> categoryTypeList = new ArrayList<>();
//          for (int i = 0; i < productInfoList.size(); i++) {
//              categoryTypeList.add(productInfoList.get(i).getCategoryType());
//          }
        //精简方法
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3. 数据拼装
        ArrayList<ProductVO> productVOS = new ArrayList<>();
        for (int i = 0; i < categoryList.size(); i++) {
            ProductVO productVO = new ProductVO();
            productVO.setCategroyName(categoryList.get(i).getCategoryName());
            productVO.setCategroyType(categoryList.get(i).getCategoryType());

            ArrayList<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (int m = 0; m < productInfoList.size(); m++) {
                if (categoryList.get(i).getCategoryType().equals(productInfoList.get(m).getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfoList.get(m),productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOS.add(productVO);
        }

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(productVOS);

        return resultVO;
    }
}
