<html>
    <#include "../common/head.ftl">
<body>

<div id="wrapper" class="toggled">

    <#--边栏sideba-->
    <#include "../common/nav.ftl">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>商品id</th>
                            <th>名称</th>
                            <th>图片</th>
                            <th>单价</th>
                            <th>库存</th>
                            <th>描述</th>
                            <th>类目</th>
                            <th>创建时间</th>
                            <th>更新时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list productInfoPage.content as productInfo>
                        <tr>
                            <td>${productInfo.productId}</td>
                            <td>${productInfo.productName}</td>
                            <td><img src="${(productInfo.productIcon)!''}" alt="图片在火星" style="height: 60px ;width: 60px"></td>
                            <td>${productInfo.productPrice}</td>
                            <td>${productInfo.productStock}</td>
                            <td>${productInfo.productDescription}</td>
                            <td>${productInfo.categoryType}</td>
                            <td>${productInfo.createTime}</td>
                            <td>${productInfo.updateTime}</td>
                            <td><a href="/sell/seller/product/index?productId=${productInfo.productId}">修改</a> </td>
                            <#if productInfo.productStatus==0>
                            <td><a href="/sell/seller/product/off_sale?productId=${productInfo.productId}">下架</a> </td>
                            <#else >
                            <td><a href="/sell/seller/product/on_sale?productId=${productInfo.productId}">上架</a> </td>
                            </#if>
                        </tr>
                        </#list>
                        </tbody>
                    </table>

                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                            <li>
                        <#if currentPage lte 1>
                            <a class="disabled" href="#">上一页</a>
                        <#else>
                            <a href="/seller/order/list?page=${currentPage - 1}&size=${size}">上一页</a>
                        </#if>
                            </li>
                    <#list 1..productInfoPage.getTotalPages() as index>
                        <li>
                            <#if index==currentPage>
                                <a class="disabled" href="#">${index}</a>
                            <#else>
                                <a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a>
                            </#if>
                        </li>
                    </#list>
                            <li>
                        <#if currentPage gte productInfoPage.getTotalPages()>
                            <a class="disabled" href="#">下一页</a>
                        <#else>
                            <a href="/sell/seller/order/list?page=${productInfoPage.getTotalPages()}&size=${size}">下一页</a>
                        </#if>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
<#--<h1>${orderDTOPage.getTotalElements()}</h1>-->
<#--<#list orderDTOPage.content as orderDTO>-->
<#--${orderDTO.orderId}</br>-->
<#--</#list>-->