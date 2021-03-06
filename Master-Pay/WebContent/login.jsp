﻿<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath %>" />
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<title>后台登录 - T-JT.admin v1.0</title>
<meta name="keywords"
	content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description"
	content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<%@ include file="View/include/header.jsp"%>
<body>
	<input type="hidden" id="TenantId" name="TenantId" value="" />
	<div class="header"></div>
	<div class="loginWraper">
		<div id="loginform" class="loginBox">
			<form class="form form-horizontal" id="myform" name="myform" action="${pageContext.request.contextPath}/admin/index" method="post" enctype=”multipart/form-data”>
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
					<div class="formControls col-xs-8">
						<input id="userName" name="userName" type="text" placeholder="账户"
							class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
					<div class="formControls col-xs-8">
						<input id="password" name="password" type="password" placeholder="密码"
							class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<label for="online"> <input type="checkbox" name="online"
							id="online" value=""> 使我保持登录状态
						</label>
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input onclick="islogin()" type="button" class="btn btn-success radius size-L" style="width: 180px;"
							value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;"/> 
						<input name="" type="reset" class="btn btn-default radius size-L" style="width: 180px;"
							value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;"/>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">Copyright 深圳市富尔美科技有限公司 by H-ui.admin v3.1</div>
<script type="text/javascript">

//登陆
function islogin(){
	sessionStorage.setItem("user-key", $('#userName').val());
	$('#myform').submit();
}

/* function index(){
	var userName = $('#userName').val();
	var password = $('#password').val();
	$.ajax({
   		url:"admin/index",
   		type:"POST",
   		data: {'userName':userName,'password':password},
   		dataType: "text", //只返回了update，所以用text
     	success:function(data){
			
			if(data == "true"){
				alert("登陆成功!");
				sessionStorage.setItem("user-key", $('#userName').val());
				window.location.href = "${ip}/admin/loadmenu?userName=" + userName + "&password=" + password; //更新后跳转
				window.location.href = "index.jsp";
			}else{
				alert("登陆失败，请重新登陆！");
				window.location.href = "${ip}/login.jsp"; //更新后跳转
			}
        	
   		},
   		error: function(XMLHttpRequest, textStatus, errorThrown) {
   			console.log(data.msg);
           }
 		}); 
	
} */

</script>
</body>
</html>