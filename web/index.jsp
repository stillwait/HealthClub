<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-04-28
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

<div id="container"></div>

<script type="text/javascript" src="../../js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/highcharts/highcharts.js"></script>

<script type="text/javascript">

    $(document).ready(function() {
        var options = {
            chart: {
                renderTo: 'container', //DIV容器ID
                type: 'column'//报表类型
            },
            //报表名称
            title:{
                text:'测试'
            },

        subtitle: {
            text: '报表说明'

        },
        yAxis: {
            min: 0,
                title: {
                text: '单位(mm)'
            }
        },
        //x轴显示内容
        xAxis: {
            categories: [ ]
        },
        //数据来源(多个对比的)
        series: [{},{},{},{}]
    };
        //json url 地址这里我使用的servlet
        var url =  "http://127.0.0.1:8080/servlet/JsonServlet";
        $.getJSON(url,function(data) {
            var i,len=data.length;
            for( i=0;i<len;i++){

                //赋值 series
                options.series[i].data = data[i].list;
                options.series[i].name = data[i].name;

                //对报表X轴显示名称赋值
                options.xAxis.categories[i]=data[i].year;
            }
            var chart = new Highcharts.Chart(options);
        });
    });

</script>


</body>
</html>
