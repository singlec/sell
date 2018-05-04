<html>
    <#include "head.ftl">
    <body>

    <div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "../common/nav.ftl">


    <#--主要内容content-->
        <div id="page-content-wrapper">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="alert alert-dismissable alert-danger">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4>
                            错误!
                        </h4> <strong>${msg}</strong>  <a href="${url}" class="alert-link">点击返回</a>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </div>
    </body>
</html>