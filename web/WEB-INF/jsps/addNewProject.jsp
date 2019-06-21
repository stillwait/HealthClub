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
    <title>健身俱乐部-健身项目管理-添加健身项目</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/sweetalert/sweetalert.css" rel="stylesheet" type="text/css">
    <link href="../../css/animate.min.css" rel="stylesheet" type="text/css">
    <%--<link href="../../css/style.min.css" rel="stylesheet" type="text/css">--%>

    <script type="text/javascript" src="../../js/previewImage/previewImage.js"></script>
</head>
<body>

<%
    List<Price> priceList = (List<Price>) request.getAttribute("priceList");
%>

<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/toWelcomePage.do">健身俱乐部信息管理系统</a></li>
                <li><a href="${pageContext.request.contextPath}/project/toProjectInfo.do">健身项目管理</a></li>
                <li class="active">添加健身项目</li>
            </ol>
            <h2 class="page-header">添加健身项目</h2>
        </div>
        <div class="form-horizontal">
            <div class="ibox-content">

                <form action="${pageContext.request.contextPath}/project/addProject.do" id="commentForm" onsubmit="return validateForm();">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">项目名称：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="proName" id="proName" class="form-control" placeholder="请输入名称"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">项目描述：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="proDescribe" id="proDescribe" class="form-control" placeholder="请输入描述"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">项目时间：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="proDate" id="proDate" class="form-control" placeholder="请输入时间,例如*周六上午9.00-11.00"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">三个月价格：</label>
                        <div class="col-sm-8">
                            <select name="priceMoney" id="priceMoney1">
                                <option value="">不开设三个月</option>
                                <%
                                    for (int i = 0 ; i < priceList.size() ; i++){
                                        if (priceList.get(i).getPriceName().equals("三个月")){%>
                                            <option value="<%=priceList.get(i).getPriceId()%>"><%=priceList.get(i).getPriceMoney() + "元"%></option>
                                        <%}%>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">半年价格：</label>
                        <div class="col-sm-8">
                            <select name="cardType" id="priceMoney2">
                                <option value="">不开设半年</option>
                                <%
                                    for (int i = 0 ; i < priceList.size() ; i++){
                                        if (priceList.get(i).getPriceName().equals("半年")){%>
                                <option value="<%=priceList.get(i).getPriceId()%>"><%=priceList.get(i).getPriceMoney() + "元"%></option>
                                <%}%>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">一年价格：</label>
                        <div class="col-sm-8">
                            <select name="cardType" id="priceMoney3">
                                <option value="">不开设一年</option>
                                <%
                                    for (int i = 0 ; i < priceList.size() ; i++){
                                        if (priceList.get(i).getPriceName().equals("一年")){%>
                                <option value="<%=priceList.get(i).getPriceId()%>"><%=priceList.get(i).getPriceMoney() + "元"%></option>
                                <%}%>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </div>

                    <div class="col-sm-10 col-sm-offset-2">
                        <button class="btn btn-primary col-sm-5 btn-submit" id="submit">保存内容</button>
                        <span style="color: #D43F3A; margin: 20px;">${msg}</span>
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
        var name = document.getElementById("proName").value;
        var date = document.getElementById("proDate").value;
//        alert($("#memDate").val());
        if(name == "")
        {
            document.getElementById("proName").style.border = "1px solid red";
            document.getElementById("proName").setAttribute("placeholder","*名称不能为空");
            document.getElementById("proName").focus();
            return false;
        }

        if(date == "")
        {
            document.getElementById("proDate").style.border = "1px solid red";
            document.getElementById("proDate").setAttribute("placeholder","*例如周六上午9.00-11.00");
            document.getElementById("proDate").focus();
            return false;
        }
        layer.msg('添加成功', {shift:6,time:3000});
    }

</script>

</body>
</html>
