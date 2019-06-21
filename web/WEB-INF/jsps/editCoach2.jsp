<%@ page import="com.club.Po.Coach" %><%--
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
    <title>健身俱乐部--教练信息</title>
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
    Coach coach = (Coach)request.getAttribute("coach");
%>

<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/toWelcomePage2.do">健身俱乐部信息管理系统</a></li>
                <li><a href="${pageContext.request.contextPath}/user/toCoachInfo2.do">教练管理</a></li>
                <li class="active">教练信息</li>
            </ol>
            <h2 class="page-header">教练信息</h2>
        </div>
        <div class="form-horizontal">
            <div class="ibox-content">

                <div style="height: 500px;width: 410px;float: left;margin-right:100px;">
                    <div id="preview">
                        <img src="<%=coach.getCoachPic()%>" id="imghead" class="pop-imghead" style="height: 500px;width: 410px;">
                    </div>
                </div>

                <div style="width: 500px;height:500px;float: left;">
                    <input type="hidden" name="coachId" value="<%=coach.getCoachId()%>">
                    <form>

                        <table style="border-collapse:separate; border-spacing:0px 30px;">
                            <tr>
                                <td><label>姓名：</label></td>
                                <td><span><%=coach.getCoachName()%></span></td>
                            </tr>
                            <tr>
                                <td><label>性别：</label></td>
                                <td><span><%=coach.getCoachSex()%></span></td>
                            </tr>
                            <tr>
                                <td><label>年龄：</label></td>
                                <td><span><%=coach.getCoachAge()%></span></td>
                            </tr>
                            <tr>
                                <td><label>学历：</label></td>
                                <td><span><%=coach.getCoachEdu()%></span></td>
                            </tr>
                            <tr>
                                <td><label>运动经历：</label></td>
                                <td><span><%=coach.getCoachExp()%></span></td>
                            </tr>
                            <tr>
                                <td><label>曾获证书：</label></td>
                                <td><span><%=coach.getCoachCert()%></span></td>
                            </tr>
                            <tr>
                                <td><label>个人特长：</label></td>
                                <td><span><%=coach.getCoachAdv()%></span></td>
                            </tr>
                            <tr>
                                <td><label>个人格言：</label></td>
                                <td><span><%=coach.getCoachMotto()%></span></td>
                            </tr>
                            <tr>
                                <td><label>电话：</label></td>
                                <td><span><%=coach.getCoachPhone()%></span></td>
                            </tr>
                        </table>

                    </form>

                    <div class="hr-line-dashed"></div>

                </div>

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


</body>
</html>
