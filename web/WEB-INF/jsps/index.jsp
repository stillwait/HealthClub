<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-03-26
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.club.Po.User" %>
<%@ page import="com.club.Po.Admin" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>零距离健身俱乐部</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/font-awesome.min.css" rel="stylesheet">
    <link href="../../css/animate.min.css" rel="stylesheet">
    <link href="../../css/style.min.css" rel="stylesheet">
    <style type="text/css">
        #index{
            margin-left: 8%;
            margin-top: 13px;
            color: green;
        }
        #index:hover{
            color: red;
        }
    </style>
</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">

<%
    Admin admin =  (Admin) session.getAttribute("admin");
%>

    <div id="wrapper">

        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <span><img alt="image" id="header-img" class="img-circle" src="<%=admin.getAdminPic()%>" width="80" height="80"/></span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=admin.getAdminName()%></strong></span>
                                <span class="text-muted text-xs block">&nbsp;&nbsp;&nbsp;个人信息<b class="caret"></b></span>
                                </span>
                            </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a class="J_menuItem" href="${pageContext.request.contextPath}/user/toUpdateUserInfo.do">个人资料</a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="${pageContext.request.contextPath}/toLoginOut.do">安全退出</a>
                                </li>
                            </ul>
                        </div>
                        <div class="logo-element"><img alt="image" class="img-circle" src="<%=admin.getAdminPic()%>" width="60" height="60"/>
                        </div>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-home"></i>
                            <span class="nav-label">会员管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="${pageContext.request.contextPath}/user/toMemberInfo.do">会员概况</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="${pageContext.request.contextPath}/member/toAddMember.do">添加会员</a>
                            </li>
                        </ul>

                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-line-chart"></i>
                            <span class="nav-label">健身项目管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="${pageContext.request.contextPath}/project/toProjectInfo.do">项目概况</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">健身器材管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/user/toEquipmentInfo.do">设备概况</a>
                            </li>
                            <%--<li><a class="J_menuItem" href="#">设备统计</a>--%>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-male"></i> <span class="nav-label">私人教练管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/user/toCoachInfo.do">教练团队</a>
                            </li>

                        </ul>
                    </li>

                    <li>
                        <a href="#"><i class="fa fa-flask"></i> <span class="nav-label">员工管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/user/toUserInfo.do">员工概况</a>
                            </li>

                        </ul>
                    </li>

                    <li>
                        <a href="#"><i class="fa fa-fax"></i> <span class="nav-label">价格管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/user/toCardPriceInfo.do">会员卡</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/user/toProjectPriceInfo.do">健身项目</a>
                            </li>
                        </ul>
                    </li>

                    <li>
                        <a href="#"><i class="fa fa-fax"></i> <span class="nav-label">工资管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/user/toUserSalaryInfo.do">员工工资</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/user/toCoachSalaryInfo.do">教练工资</a>
                            </li>
                        </ul>
                    </li>

                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">财务管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/user/toMoneyInfo.do">工资概况</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/user/toEquipmentOrderInfo.do">器材花费</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/user/toMemberListInfo.do">注册会员记录</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/user/toAddMoneyListInfo.do">会员充值记录</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/user/toAddProjectListInfo.do">办理健身记录</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->

        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header">
                        <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                        <a href="${pageContext.request.contextPath}/toIndex.do"><h2 id="index">欢迎进入零距离健身俱乐部信息管理系统</h2></a>
                    </div>
                    <ul class="nav navbar-top-links navbar-right">
                        <li class="dropdown hidden-xs">
                            <a class="right-sidebar-toggle" aria-expanded="false">
                                <i class="fa fa-tasks"></i> 主题
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="row J_mainContent" id="content-main">
                <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="${pageContext.request.contextPath}/toWelcomePage.do" frameborder="0" data-id="welcomePage.jsp" seamless></iframe>
            </div>
            <div class="footer">
                <div class="pull-right">&copy; 2019 <a href="javascript:" target="_blank">零距离健身俱乐部</a>
                </div>
            </div>
        </div>
        <!--右侧部分结束-->

        <!--右侧边栏开始-->
        <div id="right-sidebar">
            <div class="sidebar-container">

                <ul class="nav nav-tabs navs-3">

                    <li class="active">
                        <a data-toggle="tab" href="#tab-1">
                            <i class="fa fa-gear"></i> 主题
                        </a>
                    </li>
                </ul>

                <div class="tab-content">
                    <div id="tab-1" class="tab-pane active">
                        <div class="sidebar-title">
                            <h3> <i class="fa fa-comments-o"></i> 主题设置</h3>
                            <small><i class="fa fa-tim"></i> 你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。</small>
                        </div>
                        <div class="skin-setttings">
                            <div class="title">主题设置</div>
                            <div class="setings-item">
                                <span>收起左侧菜单</span>
                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="collapsemenu">
                                        <label class="onoffswitch-label" for="collapsemenu">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="setings-item">
                                <span>固定顶部</span>

                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox" id="fixednavbar">
                                        <label class="onoffswitch-label" for="fixednavbar">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="setings-item">
                                <span>
                        固定宽度
                    </span>

                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox" id="boxedlayout">
                                        <label class="onoffswitch-label" for="boxedlayout">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="title">皮肤选择</div>
                            <div class="setings-item default-skin nb">
                                <span class="skin-name ">
                         <a href="#" class="s-skin-0">
                             默认皮肤
                         </a>
                    </span>
                            </div>
                            <div class="setings-item blue-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-1">
                            蓝色主题
                        </a>
                    </span>
                            </div>
                            <div class="setings-item yellow-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-3">
                            黄色/紫色主题
                        </a>
                    </span>
                            </div>
                        </div>
                    </div>


                </div>

            </div>
        </div>
        <!--右侧边栏结束-->

    </div>

    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/metisMenu/jquery.metisMenu.js"></script>
    <script type="text/javascript" src="../../js/slimscroll/jquery.slimscroll.min.js"></script>
    <script type="text/javascript" src="../../js/layer/layer.js"></script>
    <script type="text/javascript" src="../../js/hplus.min.js"></script>
    <script type="text/javascript" src="../../js/contabs.min.js"></script>
    <script type="text/javascript" src="../../js/pace/pace.min.js"></script>


</body>
</html>
