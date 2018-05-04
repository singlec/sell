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
                    <form role="form">
                        <div class="form-group">
                            商品名称<input type="text" class="form-control" name="productName" id="productName" value="${(productInfo.productName)!""}" />
                        </div>
                        <div class="form-group">
                            价格<input type="text" class="form-control" name="productPrice" id="productPrice" value="${(productInfo.productPrice)!""}" />
                        </div>
                        <div class="form-group">
                            库存<input type="text" class="form-control" name="productStock" id="productStock" value="${(productInfo.productStock)!""}" />
                        </div>
                        <div class="form-group">
                            描述<input type="text" class="form-control" name="productDescription" id="productDescription" value="${(productInfo.productDescription)!""}" />
                        </div>
                        <div class="form-group">
                            图片
                            <img src="${(productInfo.productIcon)!""}" alt="加载失败" style="width: 200px;height: 200px">
                            <input type="text" class="form-control" name="productIcon" id="productIcon" value="${(productInfo.productIcon)!""}" />
                        </div>
                        <div class="form-group">
                            类目
                            <select class="form-control" name="categoryType">
                                <#list categoryList as category>

                                    <option value="${category.categoryId}"
                                            <#if (productInfo.categoryType)?? && category.categoryId==productInfo.categoryType>selected="selected"</#if>
                                    >${category.categoryName}</option>

                                </#list>
                            </select>
                        </div>
                        </div> <button type="submit" class="btn btn-default">提交</button>
                    </form>
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