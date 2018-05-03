<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-bordered table-condensed">
                <thead>
                <tr>
                    <th>商品id</th>
                    <th>姓名</th>
                    <th>手机号</th>
                    <th>地址</th>
                    <th>金额</th>
                    <th>订单状态</th>
                    <th>支付状态</th>
                    <th>创建时间</th>
                    <th colspan="2">操作</th>
                </tr>
                </thead>
                <tbody>
                        <#list orderDTOPage.content as orderDTO>
                        <tr>
                            <td>${orderDTO.orderId}</td>
                            <td>${orderDTO.buyerName}</td>
                            <td>${orderDTO.buyerPhone}</td>
                            <td>${orderDTO.buyerAddress}</td>
                            <td>${orderDTO.orderAmount}</td>
                            <td>${orderDTO.getOrderStatusEnum().getMessage()}</td>
                            <td>${orderDTO.getPayStatusEnum().getMessage()}</td>
                            <td>${orderDTO.createTime}</td>
                            <td>详情</td>
                            <td>取消</td>
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
                    <#list 1..orderDTOPage.getTotalPages() as index>
                        <li>
                            <#if index==currentPage>
                                <a class="disabled" href="#">${index}</a>
                            <#else>
                                <a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a>
                            </#if>
                        </li>
                    </#list>
                    <li>
                        <#if currentPage gte orderDTOPage.getTotalPages()>
                            <a class="disabled" href="#">下一页</a>
                        <#else>
                            <a href="/sell/seller/order/list?page=${orderDTOPage.getTotalPages()}&size=${size}">下一页</a>
                        </#if>
                    </li>
                </ul>
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