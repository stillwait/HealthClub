<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-05-05
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>财务概况</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../../js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/echarts/echarts.min.js"></script>

    <style type="text/css">
        .form-group{
            height: 35px;
            padding: 0 100px 0 80%;
        }
        #label{
            font-size: 16px;
            float: left;
        }
        #select{
            width: 100px;
            float: left;
        }
    </style>

</head>

<body>

<%
    List<String> year = (List<String>) request.getAttribute("year");
%>

<div class="form-group">
    <label id="label">年份：</label>
    <div id="select">
        <select name="year" id="year" onchange="loadSalary()">
            <option value="">请选择</option>
            <%
                if (year == null){%>
            <option value="0">无</option>
                <%}else{
                    for (int i = 0 ; i < year.size() ; i++){%>
                        <option value="<%=year.get(i)%>"><%=year.get(i)%></option>
                <%}%>
            <%}%>

        </select>
    </div>
</div>

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="container" style="width: 1600px;height:750px;"></div>

<script type="text/javascript">
    
    $(document).ready(function () {
        var year = <%=year%>;
        var temp = year.sort(function(a, b){return b - a;})[0];
        loadSalary(temp);
    });

    function loadSalary(temp){
        var year = $('#year').val();
        if (temp){
            year=temp;
        }
        var xValue=[];    //类别数组（实际用来盛放X轴坐标值）
        var userY=[];    //销量数组（实际用来盛放Y坐标值）
        var coachY=[];
        $.ajax({
            type : "post",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : "${pageContext.request.contextPath}/money/selectSalary.do",    //请求发送到TestServlet处
            data : {"year":year},
            dataType : "json",        //返回数据形式为json
            success : function(result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
//                console.info(result);
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
//    loadSalary();

    function loadSalaryTable(xValue, userY, coachY){
//        console.info(userY);
//        console.info(coachY);
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
                    type: 'bar',
                    data: userY
                },
                {
                    name: '教练',
                    type: 'bar',
                    data: coachY
                }
            ]
        };
        if (option && typeof option === "object") {
            myChart.setOption(option, true);
        }
    }



</script>

</body>

</html>