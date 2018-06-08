<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<title>系统日志</title>
</head>
<body>

	<table id="sysytemlog-list" class="table table-border table-bordered table-bg table-hover table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="80">ID</th>
				<th>日志内容</th>
				<th width="120">时间</th>
				<!-- <th width="70">操作</th> -->
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="list">
			<tr class="text-c">
				<td><input type="checkbox" value="" name=""></td>
				<td>${list.id}</td>
				<td>${list.requestdata}</td>
				<td><fmt:formatDate value="${list.addtime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="tcdPageBox clearfix">
		<div class="tcdPageCode" id="tcdPageCodes1"></div>
		<div>
			<input type="hidden"  value="${pu.currentpage }"id="currentpage1" />
			<input type="hidden" value="${pu.sumpage}" id="sumpage1" />
			<input type="hidden" value="${table_index}" id="table_index1">
		</div>
	</div>
	<script type="text/javascript">
		/* 加载分页 */
		/* 加载分页 */
		$("#tcdPageCodes1").createPage({
			pageCount : parseInt($("#sumpage1").val()),
			current : parseInt($("#currentpage1").val()),
			backFn : function(p) {
				queryLog(p);
			}
		});
		function pageCreate() {
			$("#tcdPageCodes1").ajaxcreatePage({
				pageCount : parseInt(sumpage),
				current : parseInt(currentPage),
			});
		}
	</script>
</body>
</html>