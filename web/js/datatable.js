/**
 * Created by Administrator on 2019-04-18.
 */
function loadUserList() {
// init_column_tool_bar();
    $(function() {
        var table = $("#userdatatable").DataTable({
            "processing": true,
            "serverSide": true,
            'ajax': {
                'contentType': 'application/json',
                'url': "${pageContext.request.contextPath}/member/selectAllMember.do",
                'type': 'POST',
                'data': function(d) {
                    return JSON.stringify(d);
                }
            },
            "aLengthMenu": [10, 30, 50, 100], //动态指定分⻚后每⻚显示的记录数。
            "searching": true, //禁⽤搜索
            "lengthChange": true, //是否启⽤改变每⻚显示多少条数据的控件
            "sort": "position", //是否开启列排序，对单独列的设置在每⼀列的bSortable选项中指定
            "deferRender": true, //延迟渲染
            "bStateSave": false, //在第三⻚刷新⻚⾯，会⾃动到第⼀⻚
            "iDisplayLength": 10, //默认每⻚显示多少条记录
            "iDisplayStart": 0,
            "ordering": true,//全局禁⽤排序
//"dom": '<l<\'#topPlugin\'>f>rt<ip><"clear">',
            "columns": [{
                "name": "id", // 指定的列
                "data": "id",
                "ordering": true, // 禁⽤排序
                "swidth": "2%",
                "render": function(data, type, full, meta) {
                    return '<div class="checker"> <label> <input type="checkbox" class="checkboxes" value="' + data + '"> <span class="text"></span> </label> </div>';
                }
            }, {
                "name": "id", // 指定的列
                "data": "id",
                "ordering": true, // 禁⽤排序
                "swidth": "6%",
// "render": function (data, type, full, meta) {
// return '<div class="checker"> <label> <input type="checkbox" class="checkboxes" value="' + data + '"> <span class="text"></span> </label> </div>';
// }
            }, {
                "name": "userName", // 指定的列
                "data": "userName",
                "ordering": false, // 禁⽤排序
// "searchable": false,
                "width": "10%"
            }, {
                "name": "roleName", // 指定的列
                "data": "roleName",
                "ordering": false, // 禁⽤排序
                "width": "10%"
            }, {
                "name": "realName", // 指定的列
                "data": "realName",
                "ordering": false, // 禁⽤排序
                "width": "7%"
            }, {
                "name": "sex", // 指定的列
                "data": "sex",
                "ordering": false, // 禁⽤排序
                "width": "5%"
            }, {
                "name": "birthday", // 指定的列
                "data": "birthday",
                "ordering": false, // 禁⽤排序
                "width": "10%"
            }, {
                "name": "area", // 指定的列
                "data": "area",
                "ordering": false, // 禁⽤排序
                "width": "15%"
            }, {
                "name": "industry.name", // 指定的列
                "data": "industry.name",
                "ordering": false, // 禁⽤排序
                "width": "10%"
            }, {
                "name": "jobName",
                "data": "jobName",
                "ordering": false, // 禁⽤排序
                "width": "10%",
// "render": function (data, type, full, meta) { //render改变该列样式,4个参
//                 数，其中参数数量是可变的。
// return '<button name="editColumn" class="btn btn-danger btn-sm
//         btn-row" data-id=' + data + '>编 辑</button>';
// }
    }, {
            "name": "pnum", // 指定的列
                "data": "pnum",
                "ordering": false, // 禁⽤排序
                "width": "5%"
        }, {
            "name": "id",
                "data": "id",
                "ordering": false, // 禁⽤排序
                "width": "8%",
                "render": function(data, type, full, meta) { //render改变该列样式,4个参数，其中参数数量是可变的。
                 return '<button name="userDetail" class="btn btn-danger btn-sm btn-row" data-id=' + data + '>编 辑</button>';
            }
        }
//data指该⾏获取到的该列数据
//row指该⾏，可⽤row.name或row[2]获取第3列字段名为name的值
//type调⽤数据类型，可⽤类型“filter”,"display","type","sort",具体⽤法还未研究
//meta包含请求⾏索引，列索引，tables各参数等信息
        ],
        "columnDefs": [{
            "targets": 8,
            "createdCell": function(td, cellData, rowData, row, col) {
                if(rowData['canEmpty'] || rowData['invalidCount'] === 0) {
                    $(td).addClass('normal');
                } else {
                    $(td).addClass('error');
                }
            }
        }],
            "oLanguage": { // 国际化配置
            "sProcessing": "正在获取数据，请稍后...",
                "sLengthMenu": "显示 _MENU_ 条",
                "sZeroRecords": "没有找到数据",
                "sInfo": "从 _START_ 到 _END_ 条记录 总记录数为 _TOTAL_ 条",
                "sInfoEmpty": "记录数为0",
                "sInfoFiltered": "(全部记录数 _MAX_ 条)",
                "sInfoPostFix": "",
                "sSearch": "搜索",
                "sUrl": "",
                "oPaginate": {
                "sFirst": "第⼀⻚",
                    "sPrevious": "上⼀⻚",
                    "sNext": "下⼀⻚",
                    "sLast": "最后⼀⻚"
            }
        },
        initComplete: initComplete,
            drawCallback: function(settings) {
            $('input[name=allChecked]')[0].checked = false; //取消全选状态
            initComplete();
        }
    });
        /**
         * 表格加载渲染完毕后执⾏的⽅法
         * @param data
         */
        function initComplete(data) {
            initSelectedCheckbox();
            $('button[name="userDetail"]').on('click', function() {
                var id = $(this).data("id");
                open_user_detail_page(id);
            });
            $('button[name="attributeColumn"]').on('click', function() {
                var name = $(this).data("id");
// open_attribute_list_page('column', name);
            });
            $('button[name="columnDistribution"]').on('click', function() {
                var name = $(this).data("id");
// open_column_distribution_list_page(name);
            });
        }
    });
    $('#purgeUserBtn').click(function() {
        if(window.confirm('你确定删除吗？')){
            //alert("确定");
            var checkedList = $("table tbody tr input[type=checkbox]:checked");
            if(checkedList.length === 0) {
                layer.msg("⾄少选⼀个");
            } else {
                var ids = checkedList.map(function() {
                    return $(this)[0].value
                }).get().join(",");
                deleteUser(ids);
            }
        }else{
            //alert("取消");
            return false;
        }
    });
    $('#addUserBtn').click(function(){
        open_user_detail_page();
    });
}