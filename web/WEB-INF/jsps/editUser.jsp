<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-04-08
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.club.Po.User" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>健身俱乐部--员工信息</title>
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
    User user =  (User) request.getAttribute("user");
%>

<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/toWelcomePage.do">健身俱乐部信息管理系统</a></li>
                <li><a href="${pageContext.request.contextPath}/user/toUserInfo.do">员工管理</a></li>
                <li class="active">员工信息</li>
            </ol>
            <h2 class="page-header">员工信息</h2>
        </div>
        <div class="form-horizontal">
            <div class="ibox-content">

                <form action="${pageContext.request.contextPath}/user/editUser.do" id="commentForm" onsubmit="return validateForm();">

                    <input type="hidden" name="userId" value="<%=user.getUserId()%>">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="userName" class="form-control" value="<%=user.getUserName()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别：</label>
                        <div class="col-sm-8 group-print">
                            <input type="radio" name="userSex" id="man" value="男" />男
                            <input type="radio" name="userSex" id="women" value="女" />女
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">年龄：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="userAge" class="form-control" value="<%=user.getUserAge()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">电话：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="userPhone" class="form-control" value="<%=user.getUserPhone()%>"/>
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

    $(document).ready(function(){
        var sex = "<%=user.getUserSex()%>";
        if(sex == "男"){
            var val = document.getElementById("man");
            val.checked =true;
        }else{
            var val = document.getElementById("women");
            val.checked =true;
        }
    });

    function validateForm()
    {
        var name = document.getElementById("userName").value;
        var sex = document.getElementsByName("userSex");
        var age = document.getElementById("userAge").value;
        var phone = document.getElementById("userPhone").value;
        var flag = false;

        for(var i = 0; i < sex.length; i++){
            if(sex[i].checked){
                flag = true;
                break;
            }
        }
        if(name == "")
        {
            document.getElementById("userName").style.border = "1px solid red";
            document.getElementById("userName").setAttribute("placeholder","*姓名不能为空");
            document.getElementById("userName").focus();
            return false;
        }
        if(flag == false){
            layer.msg('请选择性别',{
                shift:6
            });
            return false;
        }
        if(phone == "")
        {
            layer.msg('电话不能为空', {shift:6,time:3000});
            return false;
        }else{
            var money = new Number(phone);
            if(isNaN(money)){
                layer.msg('请输入数字', {shift: 6,time:2000});
                return false;
            }else if(money.valueOf()<0) {
                layer.msg('不能是负数', {shift: 6,time:2000});
                return false;
            }else if(money.toString().length != 11){
                layer.msg('电话是11位数字', {shift: 6,time:2000});
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

