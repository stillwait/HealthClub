<%@ page import="com.club.Po.Card" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-04-29
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>零距离健身俱乐部-注册</title>
    <script src="../../js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="../../js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="../../js/layer/layer.js" type="text/javascript" charset="utf-8"></script>

    <style type="text/css">
        /*全局设置*/
        * {
            margin: 0;
            padding: 0;
        }

        /*网页背景*/
        body {
            background: url(../../images/004.jpg) no-repeat;
            background-size: cover;
        }

        /*登陆主体区*/
        #main {
            width: 600px;
            height: 750px;
            background: rgba(0,0,0,0.3);
            margin:70px auto;
            position: relative;
            border-top: 8px #0cc solid;
        }

        .x_title{
            width: 100%;
            height: 50px;
            margin-top:10px;
            line-height: 50px;
            text-align: center;
            color: #00CCCC;
            border-bottom: 1px solid #CCCCCC;
        }

        form{
            width: 500px;
            margin-left: 50px;
            margin-top: 50px;
        }
        tr{
            border: 1px solid #ddd;
            margin-bottom: 32px;
        }
        tr td span{
            width: 90px;
            height: 52px;
            line-height: 52px;
            padding-left: 20px;
            font-style: normal;
            font-size: 1em;
            font-weight:800 ;
            display: inline-block;
        }
        tr td input{
            width: 200px;
            height: 30px;
            padding: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
            -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
            box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
        }
        tr td input:focus{
            border-color: #66afe9;
            outline: 0;
            -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);
            box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6)
        }
        .radio{
            width: 15px;
            height: 15px;
        }


        /*登陆按钮*/
        #btn1 {
            display: inline;
            width: 50%;
            height: 40px;
            margin-top: 30px;
            margin-left: 20%;
            border: none;
            outline: none;
            color: #fff;
            font-size: 16px;
            background: #00CCCC;
            cursor: pointer;
        }

        #btn1:active {
            position: relative;
            top:2px;
        }

        /*登陆区底部*/
        #footer {
            width: 100%;
            height: 50px;
            line-height: 50px;
            text-align: center;
            position: absolute;
            bottom: 0;
            border-top: 1px solid #CCCCCC;
        }

        #footer a {
            color: #fff;
            font-size: 14px;
            text-decoration: none;
        }
        #footer a:hover{
            color: #00CCCC;
        }
    </style>
</head>
<body>

<%
    List<Card> cardList = (List<Card>) request.getAttribute("cardList");
%>

<div id="main">
    <div class="x_title">
        <h2 class="page-header">零距离健身俱乐部——注册</h2>
    </div>

    <div id="account">
        <form class="login_form" id="register" method="post" action="${pageContext.request.contextPath}/register.do" onsubmit="return validateForm();">
            <table>
                <tr>
                    <td><span>*姓名：</span></td>
                    <td><input id="userName" name="userName" type="text" onkeyup="changeVal(this,'name')" placeholder="请输入姓名"/></td>
                    <td id="name" style="color: red">&nbsp;</td>
                </tr>

                <tr>
                    <td><span>*性别：</span></td>
                    <td>
                        <input class="radio" type="radio" name="userSex" value="男" />男
                        <input class="radio" type="radio" name="userSex" value="女" />女
                    </td>
                </tr>

                <tr>
                    <td><span>*年龄：</span></td>
                    <td><input id="userAge" name="userAge" type="text" onkeyup="changeVal(this,'age')" placeholder="请输入年龄"/></td>
                    <td id="age">&nbsp;</td>
                </tr>

                <tr>
                    <td><span>*设置密码：</span></td>
                    <td><input id="userPwd" name="userPwd" maxlength="20" type="password" onkeyup="changeVal(this,'pwd')" placeholder="请设置密码"/></td>
                    <td id="pwd" style="color: red">&nbsp;</td>
                </tr>
                <tr>
                    <td><span>*确定密码：</span></td>
                    <td><input id="checkPwd" name="checkPwd" type="password" onkeyup="changeVal(this,'ppwd')" placeholder="请再次输入密码"/></td>
                    <td id="ppwd" style="color: red">&nbsp;</td>
                </tr>

                <tr>
                    <td><span>*会员类型：</span></td>
                    <td><select name="cardType" id="cardType">
                        <%
                            for (int i = 0 ; i < cardList.size() ; i++){
                        %>
                        <option value="<%=cardList.get(i).getCardId()%>"><%=cardList.get(i).getCardName() + cardList.get(i).getCardPrice() + "元"%></option>
                        <%
                            }
                        %>
                    </select></td>
                    <td id="card" style="color: red">&nbsp;</td>
                </tr>

                <tr>
                    <td><span>*电话：</span></td>
                    <td><input id="userPhone" name="userPhone" type="text" onkeyup="changeVal(this,'phone')" placeholder="请输入您的电话号码"/></td>
                    <td id="phone" style="color: red">&nbsp;</td>
                </tr>

                <tr>
                    <td><span>*日期：</span></td>
                    <td><input id="userDate" name="userDate" type="date"/></td>
                    <td id="date" style="color: red">&nbsp;</td>
                </tr>
            </table>

            <button id="btn1" class = "submit">注  册</button><span style="color: #D43F3A; margin-left: 5%;">${msg}</span>

        </form>
    </div>
    <div id="footer">
        <a href="${pageContext.request.contextPath}/login.do">返回登录>></a>
    </div>
</div>

<script type="text/javascript">

    function today() {
        var today=new Date();
        var submitTime=today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
        $("#userDate").attr('value',submitTime);
    }

    function validateForm()
    {
        var name = $('#userName').val();
        var sex = document.getElementsByName("userSex");
        var age = $('#userAge').val();
        var pwd = $('#userPwd').val();
        var cpwd = $('#checkPwd').val();
        var card = $('#cardType').val();
        var phone = $('#userPhone').val();
        var date = $('#userDate').val();
        var flag = false;
        for(var i = 0; i < sex.length; i++){
            if(sex[i].checked){
                flag = true;
                break;
            }
        }

        if(name == "")
        {
            document.getElementById("name").innerHTML = "*姓名不能为空";
            name.focus;
            return false;
        }
        if(flag == false)
        {
            layer.msg('请选择性别',{
                shift: 6 //动画类型
            });
            return false;
        }
        if(pwd == "" || pwd.length != 6)
        {
            document.getElementById("pwd").innerHTML="*密码为6位数字不能为空";
            pwd.focus;
            return false;
        }
        if(cpwd == "")
        {
            document.getElementById("ppwd").innerHTML="*密码为6位数字不能为空";
            cpwd.focus;
            return false;
        }else if(cpwd != "" && cpwd != pwd)
        {
            document.getElementById("ppwd").innerHTML="*密码不一致，请重新输入";
            cpwd.focus;
            return false;
        }
        if(card == "" )
        {
            document.getElementById("card").innerHTML="*请选择会员类型";
            date.focus;
            return false;
        }
        if(phone == "" || phone.length != 11)
        {
            document.getElementById("phone").innerHTML="*电话为11位数字，不能为空";
            phone.focus;
            return false;
        }
        if(date == "" )
        {
            document.getElementById("date").innerHTML="*请选择日期";
            date.focus;
            return false;
        }
    }
    function changeVal(txt,msg)
    {
        if(txt.value != "")
        {
            document.getElementById(msg).innerHTML="&nbsp";
        }
    }

</script>

</body>
</html>
