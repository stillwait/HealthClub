<%@ page import="com.club.Po.Card" %>
<%@ page import="java.util.List" %>
<%@ page import="com.club.Po.MemberCardPro" %>
<%@ page import="com.club.Po.Project" %>
<%@ page import="com.club.Po.Price" %><%--
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
    <title>办理健身</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/sweetalert/sweetalert.css" rel="stylesheet" type="text/css">
    <link href="../../css/animate.min.css" rel="stylesheet" type="text/css">
    <%--<link href="../../css/style.min.css" rel="stylesheet" type="text/css">--%>

    <script type="text/javascript" src="../../js/previewImage/previewImage.js"></script>
</head>
<body>

<%
    List<MemberCardPro> memberCardProList = (List<MemberCardPro>) request.getAttribute("memberCardProList");
    List<Project> projectList = (List<Project>) request.getAttribute("projectList");
%>

<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/toWelcomePage.do">健身俱乐部信息管理系统</a></li>
                <li><a href="${pageContext.request.contextPath}/member/toAddProject.do?id=<%=memberCardProList.get(0).getMemId()%>">办理健身</a></li>
                <li class="active">办理健身</li>
            </ol>
            <h2 class="page-header">办理健身</h2>
        </div>
        <div class="form-horizontal">
            <div class="ibox-content">

                <form action="${pageContext.request.contextPath}/member/addMemProject.do" id="commentForm" onsubmit="return validateForm();">

                    <input type="hidden" name="memId" id="memId" value="<%=memberCardProList.get(0).getMemId()%>">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="memName" id="memName" class="form-control" readonly unselectable="on" value="<%=memberCardProList.get(0).getMemName()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">会员卡：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="cardType" id="cardType" class="form-control" readonly unselectable="on" value="<%=memberCardProList.get(0).getCard().getCardName() + "/办理健身打折" + memberCardProList.get(0).getCard().getCardBenefit()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">余额：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="memMoney" id="memMoney" class="form-control" readonly unselectable="on" value="<%=memberCardProList.get(0).getMemMoney()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">健身项目：</label>
                        <div class="col-sm-8 group-print">
                            <select name="proId" id="proId" onchange="showPrice()">
                                <option value="">请选择</option>
                                <%
                                    for (int i = 0 ; i < projectList.size() ; i++){
                                %>
                                <option value="<%=projectList.get(i).getProId()%>"><%=projectList.get(i).getProName() + "/" + projectList.get(i).getProDate()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">健身时间：</label>
                        <div class="col-sm-8 group-print">
                            <select name="priceId" id="priceId" onchange="showMoney()">
                                <option value="">请选择</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">收款：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" id="realMoney" name="realMoney"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">日期：</label>
                        <div class="col-sm-8 group-print">
                            <input type="date" id="proDate" name="proDate"/>
                        </div>
                    </div>

                    <div class="col-sm-10 col-sm-offset-2">
                        <button class="btn btn-primary col-sm-5 btn-submit" id="submit">办理</button>
                        <span style="color: #D43F3A; margin: 20px;">${msg}</span>
                    </div>

                </form>

            </div>
        </div>
    </div>
</div>

<script src="../../js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../../js/layer/layer.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    
    function showPrice() {
        var project = $('#proId').val();
        var price = document.getElementById("priceId");
        $(price).empty();
        $.ajax({
            type:"post",//type可以为post也可以为get
            url:"${pageContext.request.contextPath}/member/selectPrice.do",
            data:{"proId":project},
            dataType:"json",//这里要注意如果后台返回的数据不是json格式，那么就会进入到error:function(data){}中
            success:function(data){
                $(price).prepend('<option value="">请选择</option>');
                for (var i = 0; i < data[0].price.length; i++) {
                    $(price).prepend('<option value="' + data[0].price[i].priceId + '">' + data[0].price[i].priceName + '/' + data[0].price[i].priceMoney + '</option>');
                }
            },
            error:function(data){
                alert("没有健身时间");
            }
        });
    }

    function showMoney() {
        var priceId = document.getElementById("priceId");
        var options = priceId.options;
        var index = priceId.selectedIndex;
        var text = options[index].text;
        var att = text.split("/");
        var price = <%=memberCardProList.get(0).getCard().getCardBenefit()%>;
        document.getElementById("realMoney").value = att[1] * price;
    }
    
    function validateForm()
    {
        var realMoney = new Number(document.getElementById("realMoney").value);
        var memMoney = new Number(document.getElementById("memMoney").value);
        var date = document.getElementById("proDate").value;

        if (date == ""){
            layer.msg('请选择日期', {shift: 6,time:2000});
            return false;
        }else if(realMoney.valueOf() > memMoney.valueOf()){
            layer.msg('余额不足，请充值', {shift: 6,time:2000});
            return false;
        }else {
            layer.msg('办理成功', {icon: 1,time:3000});
            return false;
        }
    }

</script>

</body>
</html>
