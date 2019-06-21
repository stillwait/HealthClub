<%@ page import="com.club.Po.Card" %>
<%@ page import="java.util.List" %>
<%@ page import="com.club.Po.MemberCardPro" %>
<%@ page import="com.club.Po.ProjectPrice" %><%--
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
    <title>健身俱乐部-健身项目管理-健身项目详细</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/sweetalert/sweetalert.css" rel="stylesheet" type="text/css">
    <link href="../../css/animate.min.css" rel="stylesheet" type="text/css">
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
    List<ProjectPrice> projectPrices = (List<ProjectPrice>) request.getAttribute("projectPriceList");
    List<String> coachList = (List<String>) request.getAttribute("coachList");
%>

<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/toWelcomePage.do">健身俱乐部信息管理系统</a></li>
                <li><a href="${pageContext.request.contextPath}/project/toProjectInfo.do">健身项目管理</a></li>
                <li class="active">健身项目详细</li>
            </ol>
            <h2 class="page-header">健身项目详细</h2>
        </div>
        <div class="form-horizontal">
            <div class="ibox-content">

                <form action="${pageContext.request.contextPath}/project/toEditProject.do" id="commentForm">

                    <input type="hidden" name="id" value="<%=projectPrices.get(0).getProId()%>">

                    <div class="form-group">
                        <label>项目名称：</label>
                        <span><%=projectPrices.get(0).getProName()%></span>
                    </div>

                    <div class="form-group">
                        <label>时间：</label>
                        <span><%=projectPrices.get(0).getProDate()%></span>
                    </div>

                    <div class="form-group">
                        <label>价格：</label>
                        <select name="proId" id="proId">
                            <%
                                for (int i = 0 ; i < projectPrices.get(0).getPrice().size(); i++){
                            %>
                            <option value="<%=projectPrices.get(0).getPrice().get(i).getPriceId()%>"><%=projectPrices.get(0).getPrice().get(i).getPriceName() + "/" + projectPrices.get(0).getPrice().get(i).getPriceMoney()%></option>
                            <%
                                }
                            %>
                        </select>

                    </div>

                    <div class="form-group">
                        <label>教练：</label>
                        <select name="coachId" id="coachId">
                            <%
                                for (int i = 0 ; i < coachList.size(); i++){
                            %>
                            <option value="<%=coachList.get(i)%>"><%=coachList.get(i)%></option>
                            <%
                                }
                            %>
                        </select>

                    </div>

                    <button class="btn btn-success" id="submit">编辑信息</button>

                </form>

            </div>
        </div>
    </div>
</div>

<script src="../../js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../../js/layer/layer.js" type="text/javascript" charset="utf-8"></script>



</body>
</html>
