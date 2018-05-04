package com.imooc.controller;

import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.CategoryService;
import com.imooc.service.OrderService;
import com.imooc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/product")
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

    @GetMapping("index")
    public ModelAndView index(@RequestParam(required = false, value = "productId") String productId,
                              Map<String, Object> map) {

        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo", productInfo);
        }

        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);

        return new ModelAndView("product/index",map);
    }


}
