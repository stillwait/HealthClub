<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-03-29
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>健身房-欢迎页面</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/sweetalert/sweetalert.css" rel="stylesheet" type="text/css">
    <link href="../../css/animate.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/style.min.css" rel="stylesheet" type="text/css">
</head>
<body class="gray-bg">

<%
    List<Integer> userList = (List<Integer>) request.getAttribute("userList");
    List<Integer> coachList = (List<Integer>) request.getAttribute("coachList");
%>

<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">

        <div class="col-sm-4">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-success pull-right">人</span>
                    <h5>员工</h5>
                </div>
                <div class="ibox-content">
                    <h1 class="no-margins">
                        <%if (userList != null){%>
                            <%=userList.size()%>
                        <%}%>
                    </h1>
                </div>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-info pull-right">人</span>
                    <h5>教练</h5>
                </div>
                <div class="ibox-content">
                    <h1 class="no-margins">
                        <%if (coachList != null){%>
                            <%=coachList.size()%>
                        <%}%>
                    </h1>
                </div>
            </div>
        </div>

        <!--s: 最后更新时间-->
        <div class="col-sm-4">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-primary pull-right">今天</span>
                    <h5>最后更新时间</h5>
                </div>
                <div class="ibox-content">
                    <h1 class="no-margins" id="today"></h1>
                </div>
            </div>
        </div>

        <!--e: 最后更新时间-->

    </div>

    <!--s: 图表-->

    <div class="row">

        <div class="col-sm-12">

            <div class="ibox float-e-margins">

                <!--s: title-->
                <div class="ibox-title">
                    <h5>工资图</h5>
                </div>
                <!--e: title-->

                <div class="ibox-content ibox-title">
                    <i class="fa fa-info-circle"></i> <span>2019年俱乐部员工和教练工资概况</span>
                </div>

                <div class="ibox-content">

                    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
                    <div id="container" style="height: 390px;width: 100%;"></div>

                </div>

                <div class="ibox-content ibox-title">
                    <i class="fa fa-info-circle"></i> <span>其他年份的工资情况请看财务管理的工资概况</span>
                </div>

            </div>

        </div>

    </div>

    <!--s: 图表-->

    <script type="text/javascript" src="../../js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/echarts/echarts.min.js"></script>
    <script type="text/javascript">

        $(document).ready(function(){
            var t=new Date();
            var y=t.getFullYear();
            var m=t.getMonth()+1;
            if(m<10){
                m="0"+m;
            }
            var d=t.getDate();
            if(d<10){
                d = "0" + d;
            }
            var theday = y+"."+m+"."+d;
            document.getElementById("today").innerHTML = theday;
            loadSalary();
        });

        function loadSalary(){
            var xValue=[];    //类别数组（实际用来盛放X轴坐标值）
            var userY=[];    //销量数组（实际用来盛放Y坐标值）
            var coachY=[];
            $.ajax({
                type : "post",
                async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                url : "${pageContext.request.contextPath}/money/selectSalary.do",    //请求发送到TestServlet处
                data : {"year":2019},
                dataType : "json",        //返回数据形式为json
                success : function(result) {
                    //请求成功时执行该函数内容，result即为服务器返回的json对象
                    if (result) {
                        for (var prop in result.user) {
                            xValue.push(prop);
                            userY.push(result.user[prop]);
                        }
                        for (var prop in result.coach) {
                            coachY.push(result.coach[prop]);
                        }
                        loadSalaryTable(xValue, userY, coachY);

                    }

                },
                error : function(errorMsg) {
                    //请求失败时执行该函数
                    alert("图表请求数据失败!");
                    myChart.hideLoading();
                }
            })
        }


        function loadSalaryTable(xValue, userY, coachY){
            var dom = document.getElementById("container");
            var myChart = echarts.init(dom);
            var app = {};
            option = null;
            var posList = [
                'left', 'right', 'top', 'bottom',
                'inside',
                'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
                'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
            ];

            app.configParameters = {
                rotate: {
                    min: -90,
                    max: 90
                },
                align: {
                    options: {
                        left: 'left',
                        center: 'center',
                        right: 'right'
                    }
                },
                verticalAlign: {
                    options: {
                        top: 'top',
                        middle: 'middle',
                        bottom: 'bottom'
                    }
                },
                position: {
                    options: echarts.util.reduce(posList, function (map, pos) {
                        map[pos] = pos;
                        return map;
                    }, {})
                },
                distance: {
                    min: 0,
                    max: 100
                }
            };

            app.config = {
                rotate: 90,
                align: 'left',
                verticalAlign: 'middle',
                position: 'insideBottom',
                distance: 15,
                onChange: function () {
                    var labelOption = {
                        normal: {
                            rotate: app.config.rotate,
                            align: app.config.align,
                            verticalAlign: app.config.verticalAlign,
                            position: app.config.position,
                            distance: app.config.distance
                        }
                    };
                    myChart.setOption({
                        series: [{
                            label: labelOption
                        }, {
                            label: labelOption
                        }, {
                            label: labelOption
                        }, {
                            label: labelOption
                        }]
                    });
                }
            };


            var labelOption = {
                normal: {
                    show: true,
                    position: app.config.position,
                    distance: app.config.distance,
                    align: app.config.align,
                    verticalAlign: app.config.verticalAlign,
                    rotate: app.config.rotate,
                    formatter: '{c}  {name|{a}}',
                    fontSize: 16,
                    rich: {
                        name: {
                            textBorderColor: '#fff'
                        }
                    }
                }
            };

            option = {
                title: {
                    text: '俱乐部年度工资统计'
                },
                color: ['#003366', '#006699'],
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'shadow'
                    }
                },
                legend: {
                    data: ['员工', '教练']
                },
                toolbox: {
                    show: true,
                    orient: 'vertical',
                    left: 'right',
                    top: 'center',
                    feature: {
                        mark: {show: true},
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                calculable: true,
                xAxis: [
                    {
                        type: 'category',
                        axisTick: {show: false},
                        data: xValue,
                        name: '月份'
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        name: '工资'
                    }
                ],
                series: [
                    {
                        name: '员工',
                        type: 'line',
                        data: userY
                    },
                    {
                        name: '教练',
                        type: 'line',
                        data: coachY
                    }
                ]
            };
            if (option && typeof option === "object") {
                myChart.setOption(option, true);
            }
        }

    </script>

</div>

</body>
</html>
