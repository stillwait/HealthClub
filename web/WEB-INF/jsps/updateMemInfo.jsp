<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-04-08
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.club.Po.Member" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>健身俱乐部--个人信息</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../../css/sweetalert/sweetalert.css" rel="stylesheet" type="text/css">
    <link href="../../css/animate.min.css" rel="stylesheet" type="text/css">
    <%--<link href="../../css/style.min.css" rel="stylesheet" type="text/css">--%>

    <script type="text/javascript" src="../../js/previewImage/previewImage.js"></script>
    <script type="text/javascript" src="../../js/pic/head/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/layer/layer.js"></script>

</head>

<body class="gray-bg">

<%
    Member member = (Member) session.getAttribute("member");
%>

<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/toWelcomePage2.do">健身俱乐部信息管理系统</a></li>
                <li><a href="#">个人信息</a></li>
                <li class="active">修改资料</li>
            </ol>
            <h2 class="page-header">修改资料</h2>
        </div>
        <div class="form-horizontal">
            <div class="ibox-content">

                <form action="${pageContext.request.contextPath}/user/updateMemInfo.do" id="commentForm">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">工号：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="memId" class="form-control" readonly unselectable="on" value="<%=member.getMemId()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">密码：</label>
                        <div class="col-sm-8 group-print">
                            <input type="password" name="memPwd" class="form-control" value="<%=member.getMemPwd()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="memName" class="form-control" value="<%=member.getMemName()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别：</label>
                        <div class="col-sm-8 group-print">
                            <input type="radio" name="memSex" id="man" value="男" />男
                            <input type="radio" name="memSex" id="women" value="女" />女
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">年龄：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="memAge" class="form-control" value="<%=member.getMemAge()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">电话：</label>
                        <div class="col-sm-8 group-print">
                            <input type="text" name="memPhone" class="form-control" value="<%=member.getMemPhone()%>"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">头像：</label>
                        <div class="col-sm-8 group-print">
                            <div class="btn-group">
                                <label class="btn btn-primary" >
                                    <button type="button" class="btn btn-primary"  data-toggle="modal" data-target="#uploadFileDownload">修改头像</button>
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label"></label>
                        <div class="col-sm-8 group-print" id="preview">
                            <img id="imghead" class="pop-imghead" style="height: 150px;width: auto">
                        </div>
                    </div>

                    <input type="text" id="downloadUrl" class="hidden" name="memPic">

                    <div class="hr-line-dashed"></div>

                    <div class="form-group">

                        <div class="col-sm-10 col-sm-offset-2">
                            <button class="btn btn-primary col-sm-5 btn-submit" id="submit" type="submit">保存内容</button>
                        </div>

                    </div>

                </form>

            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="uploadFileDownload" tabIndex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="text-center">上传文件</h4>
            </div>
            <div class="modal-body">
                <div class="head-img">
                    <img src="" id="imgs" style="width: auto;height: 300px;">
                </div>
                文件：<input onchange="get_img(this)" type="file" name="fileUpload1" id="fileUpload1"/>
                <p style="display: none; color: green" id="upload-loading">上传中....</p>
                <div class="progress-bar" id="progress-bar" style="float: none;height: auto"></div>
                <input class="model-btn" type="button" value="上传" onclick="mUploadFile('downloadUrl', 'hlimgs', 'uploadFileDownload', 'fileUpload1')" style="margin-top: 10px;"/>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="../../js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="../../js/validate/messages_zh.min.js"></script>
<script type="text/javascript" src="../../js/sweetalert/sweetalert.min.js"></script>
<script type="text/javascript" src="../../js/iCheck/icheck.min.js"></script>



<script type="text/javascript">

    $(document).ready(function(){
        var sex = "<%=member.getMemSex()%>";
        if(sex == "男"){
            var val = document.getElementById("man");
            val.checked =true;
        }else{
            var val = document.getElementById("women");
            val.checked =true;
        }
    });

    <%
        String flush = (String)request.getAttribute("reload");
        if(flush !=null && flush.equals("true")){
    %>
    window.parent.location.reload();
    <%
        }
    %>
    //API

    $(function(){

        $("#submit").bind('click',function(){

            wait();
            setTimeout(function(){ $(".ibox-print").remove();
//                window.location.replace("http://localhost:7777/toLogin.do")
//                window.location.reload();
            },3000)

        })

    });


    //参数说明：showInputId:返回的url显示的控件id， filePath：上传路径  modelId:上传完需要关闭的model的id  inputFile: 输入文件id
    function mUploadFile(showInputId, filePath, modelId, inputFile) {
        $('#upload-loading').css('display', 'block');
        var formData = new FormData();
        formData.append("file", $("#" + inputFile)[0].files[0]);
        formData.append("path", filePath);
        $.ajax({
            url: 'https://www.programan.cn/file/upload',
            data: formData,
            type: 'POST',
            cache: false,
            dataType: "json",
            mimeType: "multipart/form-data",
            processData: false,
            contentType: false,
//            xhrFields: {
//                withCredentials: true
//            },
            success: function(data) {
                if(handleAjaxResult(data, "上传成功")) {
                    $('#' + showInputId).val(data.context);
                    $('#upload-loading').css('display', 'none');
                }
                $('#' + modelId).modal('hide');
                $('#imghead').attr('src', 'https://www.programan.cn' + data.context);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                console.log(XMLHttpRequest);
                console.log(textStatus);
                console.log(errorThrown);
                console.log("上传出现异常");
                layer.msg('上传失败');
                $('#upload-loading').css('display', 'none');
            },
//            xhr: function () {
//                myXhr = $.ajaxSettings.xhr();
//                if (myXhr.upload) {
//                    //绑定progress事件的回调函数
//                    myXhr.upload.addEventListener('progress', progressHandlingFunction, false);
//                }
//                return myXhr; //xhr对象返回给jQuery使用
//            }
        });
    }

    function handleAjaxResult(data, success_message) {
        var status = data.status;
        if(status === '0' || status === 'ok' || status === 0) {
            layer.msg(success_message);
            return true;
        } else {
            layer.msg("错误: " + data.errorMsg);
            return false;
        }
    }

    function get_img(f) {
        var rd = new FileReader(); //创建文件读取对象
        var files = f.files[0]; //获取file组件中的文件
        rd.readAsDataURL(files); //文件读取装换为base64类型
        rd.onloadend = function(e) {
            document.getElementById("imgs").src = this.result;
        }
    }

    function progressHandlingFunction(event) {
        var loaded = Math.floor(100 * (event.loaded / event.total)); //已经上传的百分比
        $("#progress-bar").html(loaded + "%").css("width", loaded + "%");
    }

</script>


</body>
</html>

