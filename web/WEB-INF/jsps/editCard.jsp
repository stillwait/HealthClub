<%@ page import="com.club.Po.Coach" %>
<%@ page import="com.club.Po.Card" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-05-03
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>健身俱乐部--会员卡</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/sweetalert/sweetalert.css" rel="stylesheet" type="text/css">
    <link href="../../css/animate.min.css" rel="stylesheet" type="text/css">
    <%--<link href="../../css/style.min.css" rel="stylesheet" type="text/css">--%>

    <script type="text/javascript" src="../../js/previewImage/previewImage.js"></script>
    <script type="text/javascript" src="../../js/pic/head/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/layer/layer.js"></script>
</head>
<body>

<%
    Card card = (Card)request.getAttribute("card");
%>

<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/toWelcomePage.do">健身俱乐部信息管理系统</a></li>
                <li><a href="${pageContext.request.contextPath}/user/toCardPrice.do">会员卡</a></li>
                <li class="active">会员卡</li>
            </ol>
            <h2 class="page-header">会员卡</h2>
        </div>
        <div class="form-horizontal">
            <div class="ibox-content">

                <form action="${pageContext.request.contextPath}/card/editCard.do" id="commentForm" onsubmit="return validateForm();">

                    <input type="hidden" name="cardId" value="<%=card.getCardId()%>">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">类型：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="cardName" id="cardName" class="form-control" value="<%=card.getCardName()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">价格：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="cardPrice" id="cardPrice" class="form-control" value="<%=card.getCardPrice()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">优惠：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="cardBenefit" id="cardBenefit" class="form-control" value="<%=card.getCardBenefit()%>"/>
                        </div>
                    </div>

                    <div class="form-group">

                        <div class="col-sm-10 col-sm-offset-2">
                            <button class="btn btn-primary col-sm-5 btn-submit" id="submit" type="submit">修  改</button>
                        </div>

                    </div>

                </form>

            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="../../js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="../../js/validate/messages_zh.min.js"></script>
<script type="text/javascript" src="../../js/sweetalert/sweetalert.min.js"></script>
<script type="text/javascript" src="../../js/iCheck/icheck.min.js"></script>

<script type="text/javascript">

    function validateForm()
    {
        var name = document.getElementById("cardName").value;
        var price = document.getElementById("cardPrice").value;
        var be = document.getElementById("cardBenefit").value;

        if(name == "")
        {
            document.getElementById("cardName").style.border = "1px solid red";
            document.getElementById("cardName").setAttribute("placeholder","*类型不能为空");
            document.getElementById("cardName").focus();
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
            }
        }
        if(be == "")
        {
            document.getElementById("cardBenefit").style.border = "1px solid red";
            document.getElementById("cardBenefit").setAttribute("placeholder","*健身优惠不能为空");
            document.getElementById("cardBenefit").focus();
            return false;
        }else{
            layer.msg('添加成功', {shift:6,time:3000});
            return true;
        }
    }



</script>

</body>
</html>
