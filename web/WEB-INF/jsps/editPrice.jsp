<%@ page import="com.club.Po.Card" %>
<%@ page import="java.util.List" %>
<%@ page import="com.club.Po.Price" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-04-21
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>健身俱乐部-健身价格</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/sweetalert/sweetalert.css" rel="stylesheet" type="text/css">
    <link href="../../css/animate.min.css" rel="stylesheet" type="text/css">
    <%--<link href="../../css/style.min.css" rel="stylesheet" type="text/css">--%>

    <script type="text/javascript" src="../../js/previewImage/previewImage.js"></script>
</head>
<body>

<%
    Price price = (Price)request.getAttribute("price");
%>

<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/toWelcomePage.do">健身俱乐部信息管理系统</a></li>
                <li><a href="${pageContext.request.contextPath}/user/toPricePrice.do">健身价格</a></li>
                <li class="active">健身价格</li>
            </ol>
            <h2 class="page-header">健身价格</h2>
        </div>
        <div class="form-horizontal">
            <div class="ibox-content">

                <form action="${pageContext.request.contextPath}/price/editPrice.do" id="commentForm" onsubmit="return validateForm();">

                    <input type="hidden" id="priceId" value="<%=price.getPriceId()%>"/>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">类型：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="priceName" id="priceName" class="form-control" value="<%=price.getPriceName()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">价格：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="priceMoney" id="priceMoney" class="form-control" value="<%=price.getPriceMoney()%>"/>
                        </div>
                    </div>

                    <div class="col-sm-10 col-sm-offset-2">
                        <button class="btn btn-primary col-sm-5 btn-submit" id="submit">保存内容</button>
                    </div>

                </form>

            </div>
        </div>
    </div>
</div>

<script src="../../js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../../js/layer/layer.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">

    function validateForm()
    {
        var name = document.getElementById("priceName").value;
        var price = document.getElementById("priceMoney").value;
        if(name == "")
        {
            document.getElementById("priceName").style.border = "1px solid red";
            document.getElementById("priceName").setAttribute("placeholder","*类型不能为空");
            document.getElementById("priceName").focus();
            return false;
        }
        if(price == ""){
            layer.msg('请输入价格', {shift: 6,time:2000});
            return false;
        }else{
            var money = new Number(price);
            if(isNaN(money)){
                layer.msg('请输入数字', {shift: 6,time:2000});
                return false;
            }else if(money.valueOf()<0) {
                layer.msg('不能是负数', {shift: 6,time:2000});
                return false;
            }else if(money.toString().length > 5){
                layer.msg('不能超过5位', {shift: 6,time:2000});
                return false;
            }else{
                layer.msg('修改成功', {icon: 1,time:3000});
                return true;
            }
        }
    }

</script>

</body>
</html>
