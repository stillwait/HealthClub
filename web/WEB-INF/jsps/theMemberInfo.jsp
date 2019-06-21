<%@ page import="com.club.Po.Card" %>
<%@ page import="java.util.List" %>
<%@ page import="com.club.Po.MemberCardPro" %><%--
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
    <title>健身俱乐部-会员管理-会员详细</title>
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
    List<MemberCardPro> memberList = (List<MemberCardPro>) request.getAttribute("memberList");
%>

<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/toWelcomePage.do">健身俱乐部信息管理系统</a></li>
                <li><a href="${pageContext.request.contextPath}/user/toMemberInfo.do">会员管理</a></li>
                <li class="active">会员详细</li>
            </ol>
            <h2 class="page-header">会员详细</h2>
        </div>
        <div class="form-horizontal">
            <div class="ibox-content">

                <form action="${pageContext.request.contextPath}/member/toEditMember.do" id="commentForm">

                    <input type="hidden" name="id" value="<%=memberList.get(0).getMemId()%>">

                    <div class="form-group">
                        <label>姓名：</label>
                        <span><%=memberList.get(0).getMemName()%></span>
                    </div>

                    <div class="form-group">
                        <label>性别：</label>
                        <span><%=memberList.get(0).getMemSex()%></span>
                    </div>

                    <div class="form-group">
                        <label>年龄：</label>
                        <span><%=memberList.get(0).getMemAge()%></span>
                    </div>

                    <div class="form-group">
                        <label>会员类型：</label>
                        <span>
                            <%
                                if (memberList.get(0).getCard() != null) {
                            %>
                            <%=memberList.get(0).getCard().getCardName()%>
                            <%
                                }else{
                            %>
                            无
                            <%}%>
                        </span>
                    </div>

                    <div class="form-group">
                        <label>已报健身课程：</label>
                        <%
                            if (memberList.get(0).getCard() != null) {
                        %>
                            <%
                                for (int i=0;i<memberList.get(0).getProject().size();i++){
                            %>
                                <%if(i == 0){%>
                                    <span><%=memberList.get(0).getProject().get(i).getProName() + "-" + memberList.get(0).getProject().get(i).getProDate()%></span></br>
                                <%}else{%>
                                    <span style="margin-left: 138px;"><%=memberList.get(0).getProject().get(i).getProName() + "-" + memberList.get(0).getProject().get(i).getProDate()%></span></br>
                                <%}%>

                                <%
                                    }
                                %>
                            <%
                            }else{
                            %>
                            无
                        <%}%>

                    </div>

                    <div class="form-group">
                        <label>余额：</label>
                        <span><%=memberList.get(0).getMemMoney()%></span>
                    </div>

                    <div class="form-group">
                        <label>电话：</label>
                        <span><%=memberList.get(0).getMemPhone()%></span>
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
