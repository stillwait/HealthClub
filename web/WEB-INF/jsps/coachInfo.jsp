<%@ page import="java.util.List" %>
<%@ page import="com.club.Po.Coach" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-05-03
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>健身俱乐部--教练管理</title>
    <link href="../../js/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/font-awesome.min.css" rel="stylesheet">
    <link href="../../css/animate.min.css" rel="stylesheet">
    <%--<link href="../../css/style.min.css" rel="stylesheet">--%>

    <style type="text/css">

        .wrap .div{
            position: relative;
            padding: 0;
            width: 220px;
            height: 380px;
            margin: 50px 100px;
            /*background-color: #000000;*/
            text-align: center;
            display: inline-block;
        }
        .img{
            position: relative;
            width: 210px;
            height: 320px;
            margin: 5px 5px;
        }

        .mask{
            position: absolute;
            top: 0;
            left: 0;
            width: 220px;
            height: 330px;
            background: rgba(0,0,0,0.5);
            color: #f5f1e5;
            line-height: 150px;
            text-align: center;
            display: none;
        }
        .wrap .div:hover .mask{
            display: block;
        }
    </style>
</head>
<body>

<%
    List<Coach> list = (List<Coach>)request.getAttribute("coachList");
%>

<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/toWelcomePage.do">健身俱乐部信息管理系统</a></li>
                <li><a href="${pageContext.request.contextPath}/user/toCoachInfo.do">教练管理</a></li>
                <li class="active">教练概况</li>
            </ol>
            <h2 class="page-header">教练概况</h2>
            <div class="row">
                <div style="position: absolute;margin-left: 120px;top: 140px">
                    <a href="${pageContext.request.contextPath}/coach/toAddCoach.do" class="btn btn-success btn-sm btn-row" id="addCoach">添加教练</a>
                </div>
            </div>
        </div>

        <div class="wrap">
            <%if (list != null){
                for (int i=0;i<list.size();i++){%>

            <div class="div">
                <img class="img" src="<%=list.get(i).getCoachPic()%>"/>
                <p style="margin-top: 10px;"><%=list.get(i).getCoachName()%></p>
                <div class="mask">
                    <a href="${pageContext.request.contextPath}/coach/toEditCoach.do?id=<%=list.get(i).getCoachId()%>" style="color: palegreen">点击更改>></a></br>
                    <a href="javascript:void(0)" style="color: red" onclick='delCoach(<%=list.get(i).getCoachId()%>)'>删除</a>
                </div>
            </div>

                <%}%>
            <%}%>

        </div>
    </div>
</div>

<script type="text/javascript" src="../../js/assets/js/jquery-2.0.3.min.js"></script>
<script src="../../js/layer/layer.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">

    function delCoach(coachId) {
        layer.confirm('确定要删除吗', {
            btn: ['确定','取消'] //按钮
        }, function(){
            layer.msg('删除成功', {icon: 1});
            window.location.href = "${pageContext.request.contextPath}/coach/deleteCoach.do?id=" + coachId;

        }, function(){
            layer.msg('小心点没坏处', {shift: 6});
        });
    }

</script>

</body>
</html>
