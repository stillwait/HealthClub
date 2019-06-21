<%@ page import="com.club.Po.Card" %>
<%@ page import="java.util.List" %>
<%@ page import="com.club.Po.MemberCardPro" %>
<%@ page import="com.club.Po.Member" %><%--
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
    <title>会员充值</title>
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
            margin-left: 1%;
            width: 200px;
        }


    </style>
</head>
<body>

<%
    Member member = (Member) request.getAttribute("member");
    List<Card> cardList = (List<Card>) request.getAttribute("cardList");
%>

<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/toWelcomePage.do">健身俱乐部信息管理系统</a></li>
                <li><a href="${pageContext.request.contextPath}/member/toAddProject.do?id=<%=member.getMemId()%>">办理健身</a></li>
                <li class="active">修改会员卡</li>
            </ol>
            <h2 class="page-header">修改会员卡</h2>
        </div>
        <div class="form-horizontal">
            <div class="ibox-content">

                <form action="${pageContext.request.contextPath}/member/updateMemCard.do" id="commentForm" onsubmit="return validateForm();">

                    <input type="hidden" name="memId" value="<%=member.getMemId()%>">

                    <div class="form-group">
                        <label>余额：</label>
                        <span id="yue"><%=member.getMemMoney()%></span>
                    </div>

                    <div class="form-group">
                        <label>会员卡：</label>
                        <select name="cardId" id="card" onchange="show()">
                            <option value="">请选择</option>
                            <%
                                for (int i = 0 ; i < cardList.size() ; i++){
                            %>
                            <option value="<%=cardList.get(i).getCardId()%>"><%=cardList.get(i).getCardName() + "|" + cardList.get(i).getCardPrice()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>费用：</label>
                        <input type="text" name="money" id="money"/>
                    </div>

                    <input type="hidden" name="memMoney" id="memMoney"/>

                    <div class="form-group">
                        <label>日期：</label>
                        <input type="date" name="date" id="date"/>
                    </div>

                    <div class="form-group">
                        <button class="btn btn-primary btn-submit" id="submit">保存内容</button>
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

    function show() {

        var cardId = document.getElementById("card");
        var options = cardId.options;
        var index = cardId.selectedIndex;
        var text = options[index].text;
        var att = text.split("|");
        document.getElementById("money").value = att[1];
    }
    
    function validateForm() {
        var card = document.getElementById("card").value;
        var date = document.getElementById("date").value;
        var money = new Number(document.getElementById("money").value);
        var yue = new Number(document.getElementById("yue").innerHTML);

        if (card == ""){
            layer.msg('请选择会员卡', {shift: 6,time:2000});
            return false;
        }
        if (date == ""){
            layer.msg('请选择日期', {shift: 6,time:2000});
            return false;
        }else if(yue < money){
            layer.msg('余额不足，请充值', {shift: 6,time:2000});
            return false;
        }else{
            var memMoney = yue - money;
            document.getElementById("memMoney").value = memMoney;
            layer.msg('办理成功', {icon: 1,time:3000});
            return true;
        }
    }

</script>

</body>
</html>
