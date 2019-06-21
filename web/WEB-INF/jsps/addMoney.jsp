<%@ page import="com.club.Po.Card" %>
<%@ page import="java.util.List" %>
<%@ page import="com.club.Po.MemberCardPro" %>
<%@ page import="com.club.Po.Member" %><%--
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
    <title>会员充值</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/sweetalert/sweetalert.css" rel="stylesheet" type="text/css">
    <link href="../../css/animate.min.css" rel="stylesheet" type="text/css">
    <%--<link href="../../css/style.min.css" rel="stylesheet" type="text/css">--%>

    <script type="text/javascript" src="../../js/previewImage/previewImage.js"></script>
    <style type="text/css">
        body{
            font-size: 16px;
        }
        label{
            margin-left: 20px;
        }
        #submit{
            margin-left: 5%;
            width: 200px;
        }

        .div{
            position: relative;
            padding: 0;
            width: 280px;
            height: 380px;
            margin: 50px 100px;
            /*background-color: #000000;*/
            text-align: center;
            display: inline-block;
        }
        .img{
            position: relative;
            width: 280px;
            height: 320px;
            margin: 5px 5px;
        }


    </style>
</head>
<body>

<%
    Member member = (Member) session.getAttribute("member");
%>

<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/toWelcomePage2.do">健身俱乐部信息管理系统</a></li>
                <li><a href="${pageContext.request.contextPath}/member/toShowMemMoney.do">余额信息</a></li>
                <li class="active">充值</li>
            </ol>
            <h2 class="page-header">充值</h2>
        </div>
        <div class="form-horizontal">
            <div class="ibox-content">
                <form action="${pageContext.request.contextPath}/member/addMemMoney.do" id="commentForm" onsubmit="return validateForm();">

                    <input type="hidden" name="memId" value="<%=member.getMemId()%>">

                    <div class="div">
                        <p>微信支付</p>
                        <img src="../../images/pay/wechat.png" class="img">
                    </div>

                    <div class="div">
                        <p>支付宝支付</p>
                        <img src="../../images/pay/alipay.png" class="img">
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label">充值：</label>
                        <input type="text" name="addMoney" id="addMoney" placeholder="请输入充值数目">
                    </div>

                    <div class="form-group">
                        <label class="col-sm-1 control-label">日期：</label>
                        <input type="date" id="date" name="date"/>
                    </div>

                    <button class="btn btn-success" id="submit">充值</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="../../js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../../js/layer/layer.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">

    function validateForm(){
        var addMoney = document.getElementById("addMoney").value;
        var date = document.getElementById("date").value;
        if(addMoney == ""){
            layer.msg('请输入充值数目', {shift: 6,time:2000});
            return false;
        }else{
            var money = new Number(addMoney);
            if(isNaN(money)){
                layer.msg('请输入数字', {shift: 6,time:2000});
                return false;
            }else if(money.valueOf()<0) {
                layer.msg('不能是负数', {shift: 6,time:2000});
                return false;
            }else if(money.toString().length > 5){
                layer.msg('不能超过5位', {shift: 6,time:2000});
                return false;
            }else if(date == "") {
                layer.msg('日期不能为空', {shift: 6, time: 2000});
                return false;
            }else{
                layer.msg('充值成功', {icon: 1,time:3000});
                return true;
            }
        }
    }

</script>

</body>
</html>
