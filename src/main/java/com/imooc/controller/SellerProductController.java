package com.imooc.controller;

import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.ProductForm;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import com.imooc.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/product")
@Slf4j
public class SellerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 订单列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(name = "page",defaultValue = "1") int page,
                                   @RequestParam(name = "size",defaultValue = "3") int size,
                                   Map<String,Object> map) {
        PageRequest pageRequest = PageRequest.of(page-1, size);

        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("product/list", map);
    }

    /**
     * 商品上架
     * @param productId
     * @param map
     * @return
     */
    @GetMapping("on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String ,Object> map) {
        try {
            productService.onSale(productId);
        } catch (SellException e) {
            map.put("url", "/sell/seller/product/list");
            map.put("msg", e.getMessage());
        }
        map.put("url", "/sell/seller/product/list");
        map.put("msg", ResultEnum.PRODUCT_ONSALE_SUCCESS.getMessage());
        return new ModelAndView("common/success", map);
    }

    /**
     * 商品下架
     * @param productId
     * @param map
     * @return
     */
    @GetMapping("off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                               Map<String ,Object> map) {
        try {
            productService.offSale(productId);
        } catch (SellException e) {
            map.put("url", "/sell/seller/product/list");
            map.put("msg", e.getMessage());

            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        map.put("msg", ResultEnum.PRODUCT_OFFSALE_SUCCESS.getMessage());

        return new ModelAndView("common/success", map);
    }

    /**
     * 去商品新增/修改页面
     * @param productId
     * @param map
     * @return
     */
    @GetMapping("index")
    public ModelAndView index(@RequestParam(required = false, value = "productId") String productId,
                              Map<String, Object> map) {

        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo", productInfo);
        }

        //查询所有类目
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);

        return new ModelAndView("product/index",map);
    }

    /**
     * 新增或修改商品
     * @param productForm 商品提交表单
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("save")
    public ModelAndView save(@Valid ProductForm productForm,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        //参数校验
        if (bindingResult.hasErrors()) {
            log.info("[保存商品],商品参数不正确,productForm={}",productForm);
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }

        ProductInfo productInfo;
        try {
            //如果productId不为空则为修改,先去查询
            if (!StringUtils.isEmpty(productForm.getProductId())) {
                productInfo = productService.findOne(productForm.getProductId());
            } else {
                productInfo = new ProductInfo();
                productForm.setProductId(KeyUtil.generateUniqueKey());
            }

            BeanUtils.copyProperties(productForm, productInfo);
            productService.save(productInfo);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("/common/error", map);
        }

        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("/common/success",map);
    }


}
