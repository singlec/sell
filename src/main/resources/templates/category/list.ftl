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
                            <th>类目id</th>
                            <th>名字</th>
                            <th>type</th>
                            <th>创建时间</th>
                            <th>更新时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list categoryList as category>
                        <tr>
                            <td>${category.categoryId}</td>
                            <td>${category.categoryName}</td>
                            <td>${category.categoryType}</td>
                            <td>${category.createTime}</td>
                            <td>${category.updateTime}</td>
                            <td><a href="/sell/seller/category/index?categoryId=${category.categoryId}">修改</a> </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">
                    提醒
                </h4>
            </div>
            <div class="modal-body">
                你有新的订单
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button onclick="Location.reload()" type="button" class="btn btn-primary">查看新的订单</button>
            </div>
        </div>

    </div>
<#--引入JavaScript    -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<#--mp3-->
<audio id="mp3" src="/sell/mp3/两个科学家在吃面.mp3" type="audio/mpeg">

<#--webSocket-->
<script>

    var websocket = null;
    if ('WebSocket' in window) {
        websocket = new WebSocket('ws://127.0.0.1/sell/webSocket');
    } else {
        alert("该浏览器不支持WebSocket")
    }

    websocket.onopen=function (ev) {
        console.log('建立新的连接');
    }

    websocket.onclose=function (ev) {
        console.log('关闭连接');
    }

    websocket.onmessage=function (ev) {
        console.log('收到消息:' + ev.data);
        $("#myModal").modal('show');
        document.getElementById("mp3").play();
        //处理时间(弹窗提醒之类)
    }

    websocket.onerror=function (ev) {
        alert('WebSocket通信出现错误');
    }

    window.onbeforeunload = function (ev) {
        websocket.close();
    };
</script>

</body>
</html>
