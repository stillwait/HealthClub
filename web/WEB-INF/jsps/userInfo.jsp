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
    <title>健身俱乐部--员工管理</title>
    <link href="../../js/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../js/assets/css/dataTables.bootstrap.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="../../js/assets/css/datatables.min.css">
    <link rel="stylesheet" href="../../js/assets/css/buttons.dataTables.min.css">
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
                    <li><a href="${pageContext.request.contextPath}/toWelcomePage.do">健身俱乐部信息管理系统</a></li>
                    <li><a href="${pageContext.request.contextPath}/user/toUserInfo.do">员工管理</a></li>
                    <li class="active">员工概况</li>
                </ol>
                <h2 class="page-header">员工概况</h2>
                <div class="row">
                    <div style="position: absolute;z-index: 2;margin-left: 69%;top: 170px">
                        <a href="${pageContext.request.contextPath}/user/toAddUser.do" class="btn btn-success btn-sm btn-row" id="addMem">添加员工</a>
                        <button class="btn btn-danger btn-sm btn-row" id="delMany">批量删除</button>
                    </div>
                </div>
            </div>
            <div class="x_content" style="position: relative;width: 80%;padding: 30px;box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.3);z-index: 1;">

                <table class="table table-striped table-bordered" id="tableuserlist">
                    <thead>
                    <tr>
                        <th>全选 <label><input type="checkbox" class="ace" name="checkall"/><span class="lbl"></span></label></th>
                        <th>员工编号</th>
                        <th>员工名称</th>
                        <th>员工性别</th>
                        <th>员工年龄</th>
                        <th>电话</th>
                        <th>操作</th>
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

        $('#tableuserlist').DataTable({
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
//            "sort" : "position",//禁用排序
            "sortable": true,
            "sortOrder": "asc", //排序方式
            "deferRender":true,//延迟渲染
            "bStateSave" : true, //在其他页面刷新，会自动到第一页
            "length" : 10,//每页显示的条数
            "start" : 0,
            "dom": '<l<\'#topPlugin\'>f>rt<ip><"clear">',
            "ordering": false,//全局禁用排序

            "ajax": {
                "type": "POST",
                "contentType":"application/json",
                "dataType":"json",
                "url": "${pageContext.request.contextPath}/user/selectAllUser.do",
                "data": function (d) {
                    var info = $('#tableuserlist').DataTable().page.info();
                    d.pageNo = info.page;}
            },
            "columns": [{
                "data": "userId",
                "ordering": false, // 禁⽤排序
                "width": "5%",
                "render": function(data, type, full, meta) {
                    var content = '<label>';
                    content += '<input type=\"checkbox\" class=\"ace\" name=\"checkuser\" value="'+data+'"/><span class=\"lbl\"></span>';
                    content += '</label>';
                    return content;
                }
            }, {
                "data": "userId",
                "bSortable": true , // 禁用排序
                "sDefaultContent" : "",//默认值
                "sWidth" : "10%"//列的宽度
            }, {
                "data": "userName",
                "bSortable": true , // 禁用排序
                "sDefaultContent" : "",//默认值
                "sWidth" : "10%"//列的宽度
            }, {
                "data": "userSex",
                "bSortable": false , // 禁用排序
                "sDefaultContent" : "",//默认值
                "sWidth" : "10%"//列的宽度
            }, {
                "data": "userAge",
                "bSortable": true , // 禁用排序
                "sDefaultContent" : "",//默认值
                "sWidth" : "10%"//列的宽度
            },  {
                "data": "userPhone",
                "bSortable": false , // 禁用排序
                "sDefaultContent" : "",//默认值
                "sWidth" : "15%"//列的宽度
            }],
            "columnDefs": [
                {
                    "targets": [6],
                    "data": "userId",
                    "render": function(data, type, full) {
                        var id = data;
                        var html = "<button class='btn btn-success btn-sm btn-row' onclick='updateUser(" + data + ")'>修改</button>";
//                        html += "&nbsp;&nbsp;<button class='btn btn-primary btn-sm btn-row' onclick='updateRole(" + data + ")'>修改权限</button>";
                        html += "&nbsp;&nbsp;<button class='btn btn-danger btn-sm btn-row' onclick='deleteUser(" + data + ")'>删除</button>";
                        return html;
                    }
                }
            ]

        });
    })

    function updateUser(data){
        window.location.href = "${pageContext.request.contextPath}/user/toEditUser.do?id=" + data;
    }

    function updateRole(data) {
        var id = data;
        var url = "${pageContext.request.contextPath}/user/toUpdateRole.do?id=" + id +"";
        $.get(url,function(user) {

            // 利用ajax加载其他网页内容到页面层
            layer.open({
                title:'详细信息',
                type: 1,
                area: ['620px', '600px'], //宽高
                content: user //把响应结果作为模态层的内容
            });

        },'html');
    }

    function deleteUser(data){
        layer.confirm('确定要删除吗', {
            btn: ['确定','取消'] //按钮
        }, function(){
            layer.msg('删除成功', {icon: 1});
            window.location.href = "${pageContext.request.contextPath}/user/deleteUser.do?id=" + data +"";

        }, function(){
            layer.msg('小心点没坏处', {shift: 6});
        });

    }
    $('#delMany').click(function() {
        if ($("input[name='checkuser']:checked")[0] == null) {
            alert("请选择需要删除的消息");
            return;
        }
        if (confirm("确认删除吗？")) {

            var ids = new Array;
            $("input[name='checkuser']:checked").each(function() {
                ids.push($(this).val());
                n = $(this).parents("tr").index() + 1; // 获取checkbox所在行的顺序
                $("table#tableuserlist").find("tr:eq(" + n + ")").remove();
                layer.msg('删除成功', {icon: 1,time:3000});
                window.location.href = "${pageContext.request.contextPath}/user/toUserInfo.do";
            });
            $.ajax({
//                type: "post",
                url: "${pageContext.request.contextPath}/user/deleteManyUser.do?ids="+ ids +"",
                dataType: "text",
                success:function(data) {

                }

            });

        }
    })


</script>

</body>
</html>
