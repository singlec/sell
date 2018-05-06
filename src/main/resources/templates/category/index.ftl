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
                    <form role="form" method="post" action="/sell/seller/category/save">
                        <div class="form-group">
                            类目名称<input type="text" class="form-control" name="categoryName" id="categoryName" value="${(productCategory.categoryName)!""}" />
                        </div>
                        <div class="form-group">
                            type<input type="text" class="form-control" name="categoryType" id="categoryType" value="${(productCategory.categoryType)!''}" />
                        </div>
                        <input hidden type="text" name="categoryId" value="${(productCategory.categoryId)!''}"/>
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