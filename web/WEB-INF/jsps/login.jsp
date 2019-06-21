<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-03-25
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>零距离健身俱乐部 - 登录</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/font-awesome.min.css" rel="stylesheet">
    <link href="../../css/animate.min.css" rel="stylesheet">
    <link href="../../css/style.min.css" rel="stylesheet">
    <link href="../../css/login.min.css" rel="stylesheet">

    <script src="../../js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="../../js/layer/layer.js" type="text/javascript" charset="utf-8"></script>
    <script>
        if(window.top!==window.self){window.top.location=window.location}
    </script>

</head>
<body class="signin">

<img src="../../images/login-bg-v2.jpg" class="sign-img">

<div class="sign-bg">

    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="logopanel m-b">
                        <h1>[ <strong>零距离健身俱乐部管理系统</strong> ]</h1>
                        <h2>运动无极限    健康零距离</h2>
                    </div>
                    <div class="m-b"></div>
                    <h4>欢迎使用 <strong>零距离健身俱乐部信息管理系统</strong></h4>
                    <ul class="m-b">

                        <strong>还没有账号？ <a href="${pageContext.request.contextPath}/toRegister.do">立即注册&raquo;</a></strong>
                    </ul>
                </div>
            </div>
            <div class="col-sm-5">
                <form class="login_form" id="loginForm" method="post" action="${pageContext.request.contextPath}/index.do" onsubmit="return validateForm();">
                    <h4 class="no-margins">登录：</h4>
                    <p class="m-t-md">登录到俱乐部管理系统</p>
                    <input type="text" id="userPhone" name="userPhone" class="form-control uname" placeholder="电话/编号" />
                    <input type="password" id="userPwd" name="userPwd" class="form-control pword m-b" placeholder="密码" />
                    <div class="con_select" style="padding: 3px;">
                        <input type="radio" name="userJob" value="会员" />会员
                        <input type="radio" name="userJob" value="管理员" />管理员
                        <span style="color: #D43F3A; margin: 10px;">${Msg}</span>
                    </div>

                    <button class="btn btn-success btn-block" id="loginButton">登录</button>
                </form>
            </div>
        </div>
        <div class="signup-footer">
            <div class="pull-left">
                &copy; 2016 All Rights Reserved. 零距离科技
            </div>
        </div>
    </div>

</div>

<script type="text/javascript" src="../../js/tips/jquery.tips.js"></script>
<script type="text/javascript">

    function validateForm()
    {
        var id = document.getElementById("userPhone").value;
        var pwd = document.getElementById("userPwd").value;
        var flag = false;
        var job = document.getElementsByName("userJob");
        for(var i = 0; i < job.length; i++){
            if(job[i].checked){
                flag = true;
                break;
            }
        }
        if(id == "")
        {
            document.getElementById("userPhone").style.border = "1px solid red";
            document.getElementById("userPhone").setAttribute("placeholder","*编号/电话不能为空");
            document.getElementById("userPhone").focus();
            return false;
        }else if (id.length != 6 || id.length != 11){
            document.getElementById("userPhone").style.border = "1px solid red";
            document.getElementById("userPhone").setAttribute("placeholder","*编号6位，电话11位");
            document.getElementById("userPhone").focus();
        }
        if(pwd == "")
        {
            document.getElementById("userPwd").style.border = "1px solid red";
            document.getElementById("userPwd").setAttribute("placeholder","*密码不能为空");
            document.getElementById("userPwd").focus();
            return false;
        }
        if(flag == false){
            layer.msg('请选择角色',{
                shift:6
            });
            return false;
        }
    }

//    $(function(){
//        $("#loginForm").tipsy()
//    })

</script>

</body>
</html>
