<%@ page import="com.club.Po.CoachSalary" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-04-08
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>健身俱乐部--员工工资</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/sweetalert/sweetalert.css" rel="stylesheet" type="text/css">
    <link href="../../css/animate.min.css" rel="stylesheet" type="text/css">
    <%--<link href="../../css/style.min.css" rel="stylesheet" type="text/css">--%>

    <script type="text/javascript" src="../../js/previewImage/previewImage.js"></script>
    <script type="text/javascript" src="../../js/pic/head/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/layer/layer.js"></script>

</head>

<body class="gray-bg">

<%
    CoachSalary coachSalary =  (CoachSalary) session.getAttribute("coachSalary");
%>

<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/toWelcomePage.do">健身俱乐部信息管理系统</a></li>
                <li><a href="${pageContext.request.contextPath}/user/toCoachSalaryInfo.do">教练工资</a></li>
                <li class="active">教练工资</li>
            </ol>
            <h2 class="page-header">教练工资</h2>
        </div>
        <div class="form-horizontal">
            <div class="ibox-content">

                <form action="${pageContext.request.contextPath}/coach/editCoachSalary.do" id="commentForm" onsubmit="return validateForm();">

                    <input type="hidden" name="id" value="<%=coachSalary.getId()%>">
                    <input type="hidden" name="coachId" value="<%=coachSalary.getCoachId()%>">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="coachName" class="form-control" value="<%=coachSalary.getCoachName()%>"/>
                        </div>
                    </div>

                    <input type="hidden" name="userRole" value="<%=coachSalary.getUserRole()%>">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">年份：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="year" class="form-control" value="<%=coachSalary.getYear()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">月份：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="month" class="form-control" value="<%=coachSalary.getMonth()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">基本工资：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="baseSalary" class="form-control" value="<%=coachSalary.getBaseSalary()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">出勤天数：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="cqts" class="form-control" value="<%=coachSalary.getCqts()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">缺勤天数：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="qqts" class="form-control" value="<%=coachSalary.getQqts()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">加班时长：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="overTime" class="form-control" value="<%=coachSalary.getOverTime()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">加班工资：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="overSalary" class="form-control" value="<%=coachSalary.getOverSalary()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">奖金：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="jiangJin" class="form-control" value="<%=coachSalary.getJiangJin()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">应发工资：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="yfSalary" class="form-control" value="<%=coachSalary.getYfSalary()%>"/>
                        </div>
                    </div>

                    <div class="form-group">

                        <div class="col-sm-10 col-sm-offset-2">
                            <button class="btn btn-primary col-sm-5 btn-submit" id="submit" type="submit">保存内容</button>
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
        var name = document.getElementById("coachName").value;
        var year = document.getElementById("year").value;
        var month = document.getElementById("month").value;
        var base = document.getElementById("baseSalary").value;
        var yf = document.getElementById("yfSalary").value;
        var cq = document.getElementById("cqts").value;

        if(name == "")
        {
            document.getElementById("coachName").style.border = "1px solid red";
            document.getElementById("coachName").setAttribute("placeholder","*姓名不能为空");
            document.getElementById("coachName").focus();
            return false;
        }
        if(year == "")
        {
            document.getElementById("year").style.border = "1px solid red";
            document.getElementById("year").setAttribute("placeholder","*年份不能为空");
            document.getElementById("year").focus();
            return false;
        }
        if(month == "")
        {
            document.getElementById("month").style.border = "1px solid red";
            document.getElementById("month").setAttribute("placeholder","*月份不能为空");
            document.getElementById("month").focus();
            return false;
        }
        if(base == "")
        {
            document.getElementById("base").style.border = "1px solid red";
            document.getElementById("base").setAttribute("placeholder","*基本工资不能为空");
            document.getElementById("base").focus();
            return false;
        }
        if(cq == "")
        {
            document.getElementById("cq").style.border = "1px solid red";
            document.getElementById("cq").setAttribute("placeholder","*出勤天数不能为空");
            document.getElementById("cq").focus();
            return false;
        }
        if(yf == "")
        {
            document.getElementById("yf").style.border = "1px solid red";
            document.getElementById("yf").setAttribute("placeholder","*应发工资不能为空");
            document.getElementById("yf").focus();
            return false;
        }
    }

</script>


</body>
</html>

