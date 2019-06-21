<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-04-18
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>零距离健身俱乐部--器材管理</title>
    <link href="../../js/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../js/assets/css/dataTables.bootstrap.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="../../js/assets/css/datatables.min.css">
    <link rel="stylesheet" href="../../js/assets/css/buttons.dataTables.min.css">
    <%--<link href="../../css/style.min.css" rel="stylesheet">--%>
    <link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/animate.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/sweetalert/sweetalert.css" rel="stylesheet" type="text/css">

</head>
<body>

<div>
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <ol class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}/toWelcomePage2.do">健身俱乐部信息管理系统</a></li>
                    <li><a href="${pageContext.request.contextPath}/user/toEquipmentInfo2.do">健身器材管理</a></li>
                    <li class="active">器材概况</li>
                </ol>
                <h2 class="page-header">器材概况</h2>
                <%--<div class="row">--%>
                    <%--<div style="position: absolute;z-index: 2;margin-left: 69%;top: 170px">--%>
                        <%--<a href="${pageContext.request.contextPath}/equipment/toAddEquipment.do" class="btn btn-success btn-sm btn-row" id="addMem">添加器材</a>--%>
                        <%--<button class="btn btn-danger btn-sm btn-row" id="delMany">批量删除</button>--%>
                    <%--</div>--%>
                <%--</div>--%>
            </div>
            <div class="x_content" style="position: relative;width: 80%;padding: 30px;box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.3);z-index: 1;">

                <table class="table table-striped table-bordered" id="tableequipmentlist">
                    <thead>
                    <tr>
                        <th>全选 <label><input type="checkbox" class="ace" name="checkall"/><span class="lbl"></span></label></th>
                        <th>序号</th>
                        <th>器材名称</th>
                        <th>数量</th>
                        <th>描述</th>
                        <%--<th>操作</th>--%>
                    </tr>
                    </thead>

                </table>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="../../js/assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="../../js/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/assets/js/skins.min.js"></script>
<script type="text/javascript" src="../../js/assets/js/datatable/datatables-init.js"></script>
<script type="text/javascript" src="../../js/assets/js/datatable/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../../js/assets/js/datatable/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/assets/js/datatable/dataTables.tableTools.min.js"></script>
<script type="text/javascript" src="../../js/assets/js/datatable/ZeroClipboard.js"></script>
<script type="text/javascript" src="../../js/assets/js/datatable/dataTables.buttons.min.js"></script>
<script src="../../js/layer/layer.js" type="text/javascript" charset="utf-8"></script>


<script type="text/javascript">

    $(document).ready(function(){

        $('#tableequipmentlist').DataTable({
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": '<span class="label label-success">搜索关键字： </span>',
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                }, "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "aLengthMenu":[5,10],//每页显示的条数，下拉框
            "searching":true,//禁用搜索
            "lengthChange":true,
            "paging": true,//开启表格分页
            "bProcessing" : true,//翻页时显示正在加载中
            //"bServerSide" : true,//服务端模式
            "bAutoWidth" : false,//是否自动适应宽度
            "sort" : "position",//禁用排序
            "deferRender":true,//延迟渲染
            "bStateSave" : true, //在其他页面刷新，会自动到第一页
            "length" : 5,//每页显示的条数
            "start" : 0,
            "dom": '<l<\'#topPlugin\'>f>rt<ip><"clear">',
            "ordering": false,//全局禁用排序

            "ajax": {
                "type": "POST",
                "contentType":"application/json",
                "dataType":"json",
                "url": "${pageContext.request.contextPath}/equipment/selectAllEquipment.do",
                //查询传的参数
                /*"data":function(d){
                 d.state=$("#state").val();
                 d.deptname=$("#deptname").val().trim();
                 d.startTime=$("#startTime").val();
                 d.endTime=$("#endTime").val();
                 }*/
                "data": function (d) {
                    var info = $('#tableequipmentlist').DataTable().page.info();
                    d.pageNo = info.page;}
            },
            "columns": [{
                "data": "equId",
                "ordering": false, // 禁⽤排序
                "width": "5%",
                "render": function(data, type, full, meta) {
                    var content = '<label>';
                    content += '<input type=\"checkbox\" class=\"ace\" name=\"checkproject\" value="'+data+'"/><span class=\"lbl\"></span>';
                    content += '</label>';
                    return content;
                }
            }, {
                "data": "equId",
                "orderable": false , // 禁用排序
                "sDefaultContent" : "",//默认值
                "sWidth" : "10%"//列的宽度
            }, {
                "data": "equName",
                "orderable": false , // 禁用排序
                "sDefaultContent" : "",//默认值
                "sWidth" : "15%"//列的宽度
            }, {
                "data": "equNumber",
                "orderable": false , // 禁用排序
                "sDefaultContent" : "",//默认值
                "sWidth" : "15%"//列的宽度
            }, {
                "data": "equType",
                "orderable": false , // 禁用排序
                "sDefaultContent" : "",//默认值
                "sWidth" : "30%"//列的宽度
            }]

        });
    });




</script>

</body>
</html>
