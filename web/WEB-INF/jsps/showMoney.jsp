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
            width: 200px;
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
                <li class="active">余额</li>
            </ol>
            <h2 class="page-header">余额</h2>
        </div>
        <div class="form-horizontal">
            <div class="ibox-content">

                <input type="hidden" name="memId" value="<%=member.getMemId()%>">

                <div class="form-group">
                    <label>姓名：</label>
                    <span><%=member.getMemName()%></span>
                </div>

                <div class="form-group">
                    <label>余额：</label>
                    <span><%=member.getMemMoney()%></span>
                </div>

                <button class="btn btn-success" id="submit" onclick="pay()">充值</button>

            </div>
        </div>
    </div>
</div>

<script src="../../js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../../js/layer/layer.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">

    function pay(){
        window.location.href = "${pageContext.request.contextPath}/member/toAddMemMoney.do";
    }

</script>

</body>
</html>
