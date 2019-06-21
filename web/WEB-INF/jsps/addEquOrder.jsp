<%@ page import="com.club.Po.Card" %>
<%@ page import="java.util.List" %><%--
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
    <title>健身俱乐部——器材花费</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/sweetalert/sweetalert.css" rel="stylesheet" type="text/css">
    <link href="../../css/animate.min.css" rel="stylesheet" type="text/css">
    <%--<link href="../../css/style.min.css" rel="stylesheet" type="text/css">--%>

    <script type="text/javascript" src="../../js/previewImage/previewImage.js"></script>
</head>
<body>

<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/toWelcomePage.do">健身俱乐部信息管理系统</a></li>
                <li><a href="${pageContext.request.contextPath}/user/toEquipmentOrderInfo.do">器材花费</a></li>
                <li class="active">器材花费</li>
            </ol>
            <h2 class="page-header">器材花费</h2>
        </div>
        <div class="form-horizontal">
            <div class="ibox-content">

                <form action="${pageContext.request.contextPath}/equipment/addEquOrder.do" id="commentForm" onsubmit="return validateForm();">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">器材编号：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="equId" id="equId" class="form-control" placeholder="请输入器材编号"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">器材名称：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="equName" id="equName" class="form-control" placeholder="请输入名称"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">数量：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="equNumber" id="equNumber" class="form-control" onkeyup="add()" placeholder="请输入数量"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">单价：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="equPrice" id="equPrice" class="form-control" onkeyup="add()" placeholder="请输入器材单价"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">总价：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="equMoney" id="equMoney" class="form-control" onClick="add()" placeholder="请输入器材描述"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">日期：</label>
                        <div class="col-sm-8 group-print">
                            <input type="date" id="equDate" name="equDate"/>
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

    function add(){
        var num1=0;
        var num2=0;
        if(document.all.equNumber.value!=""){
            var money1 = new Number(document.getElementById("equNumber").value);
            if(isNaN(money1)){
                layer.msg('请输入数字', {shift: 6,time:2000});
            }else if(money1.valueOf()<0) {
                layer.msg('不能是负数', {shift: 6,time:2000});
            }else if(money1.toString().length > 5){
                layer.msg('不能超过5位', {shift: 6,time:2000});
            }else{
                num1=parseFloat(document.all.equNumber.value);
            }
        }
        if(document.all.equPrice.value!=""){
            var money2 = new Number(document.getElementById("equPrice").value);
            if(isNaN(money2)){
                layer.msg('请输入数字', {shift: 6,time:2000});
            }else if(money2.valueOf()<0) {
                layer.msg('不能是负数', {shift: 6,time:2000});
            }else if(money2.toString().length > 5){
                layer.msg('不能超过5位', {shift: 6,time:2000});
            }else{
                num2=parseFloat(document.all.equPrice.value);
            }
        }
        document.all.equMoney.value=num1 * num2;
    }

    function validateForm()
    {
        var id = document.getElementById("equId").value;
        var name = document.getElementById("equName").value;
        var number = document.getElementById("equNumber").value;
        var price = document.getElementById("equPrice").value;
        var money = document.getElementById("equMoney").value;
        var date = document.getElementById("equDate").value;
//        alert($("#memDate").val());
        if(id == "")
        {
            document.getElementById("equId").style.border = "1px solid red";
            document.getElementById("equId").setAttribute("placeholder","*编号不能为空");
            document.getElementById("equId").focus();
            return false;
        }
        if(name == "")
        {
            document.getElementById("equName").style.border = "1px solid red";
            document.getElementById("equName").setAttribute("placeholder","*姓名不能为空");
            document.getElementById("equName").focus();
            return false;
        }
        if(number == "")
        {
            document.getElementById("equNumber").style.border = "1px solid red";
            document.getElementById("equNumber").setAttribute("placeholder","*数量不能为空");
            document.getElementById("equNumber").focus();
            return false;
        }
        if(price == "")
        {
            document.getElementById("equPrice").style.border = "1px solid red";
            document.getElementById("equPrice").setAttribute("placeholder","*单价不能为空");
            document.getElementById("equPrice").focus();
            return false;
        }
        if(money == "")
        {
            document.getElementById("equMoney").style.border = "1px solid red";
            document.getElementById("equMoney").setAttribute("placeholder","*总价不能为空");
            document.getElementById("equMoney").focus();
            return false;
        }
        if(date == "")
        {
            document.getElementById("equDate").style.border = "1px solid red";
            document.getElementById("equDate").setAttribute("placeholder","*日期不能为空");
            document.getElementById("equDate").focus();
            return false;
        }
        layer.msg('添加成功', {shift:6,time:3000});
    }

</script>

</body>
</html>
