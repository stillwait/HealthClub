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
    <title>健身俱乐部-会员管理-添加会员</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/sweetalert/sweetalert.css" rel="stylesheet" type="text/css">
    <link href="../../css/animate.min.css" rel="stylesheet" type="text/css">
    <%--<link href="../../css/style.min.css" rel="stylesheet" type="text/css">--%>

    <script type="text/javascript" src="../../js/previewImage/previewImage.js"></script>
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
                <li class="active">编辑会员</li>
            </ol>
            <h2 class="page-header">编辑会员</h2>
        </div>
        <div class="form-horizontal">
            <div class="ibox-content">

                <form action="${pageContext.request.contextPath}/member/editMember.do" id="commentForm" onsubmit="return validateForm();">

                    <input type="hidden" name="id" value="<%=memberList.get(0).getMemId()%>">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="memName" id="memName" class="form-control" value="<%=memberList.get(0).getMemName()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">密码：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="memPwd" id="memPwd" class="form-control" value="<%=memberList.get(0).getMemPwd()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-8 group-print">
                            <input type="radio" name="memSex" id="man" value="男" />男
                            <input type="radio" name="memSex" id="women" value="女" />女
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">年龄</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="memAge" id="memAge" class="form-control" value="<%=memberList.get(0).getMemAge()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">日期</label>
                        <div class="col-sm-8 group-print">
                            <input type="date" value="2019-04-25" id="memDate" name="memDate"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">电话</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="memPhone" id="memPhone" class="form-control"value="<%=memberList.get(0).getMemPhone()%>"/>
                        </div>
                    </div>

                    <div class="col-sm-10 col-sm-offset-2">
                        <button class="btn btn-primary col-sm-5 btn-submit" id="submit">保存内容</button>
                    </div>

                </form>

            </div>
        </div>
    </div>
</div>

<script src="../../js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../../js/layer/layer.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">

    $(document).ready(function(){
        var sex = "<%=memberList.get(0).getMemSex()%>";
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
        var name = document.getElementById("memName").value;
        var pwd = document.getElementById("memPwd").value;
        var sex = document.getElementsByName("memSex");
        var age = document.getElementById("memAge").value;
        var phone = document.getElementById("memPhone").value;
        var flag = false;

        for(var i = 0; i < sex.length; i++){
            if(sex[i].checked){
                flag = true;
                break;
            }
        }
        if(name == "")
        {
            document.getElementById("memName").style.border = "1px solid red";
            document.getElementById("memName").setAttribute("placeholder","*姓名不能为空");
            document.getElementById("memName").focus();
            return false;
        }
        if(pwd == "")
        {
            document.getElementById("memPwd").style.border = "1px solid red";
            document.getElementById("memPwd").setAttribute("placeholder","*密码不能为空");
            document.getElementById("memPwd").focus();
            return false;
        }
        if(flag == false){
            layer.msg('请选择性别',{
                shift:6
            });
            return false;
        }
        if(age == "")
        {
            document.getElementById("memAge").style.border = "1px solid red";
            document.getElementById("memAge").setAttribute("placeholder","*年龄不能为空");
            document.getElementById("memAge").focus();
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
