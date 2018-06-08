<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <% String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <base href="<%=basePath%>" /> --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<title>SIM卡管理ajax页面</title>
</head>
<body>

		<table id="sim-list" class="table table-border table-bordered table-hover table-bg table-sort">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="25">ID</th>
					<th width="25">SIM卡编号</th>
					<th width="25">卡池编号</th>
					<th width="25">卡槽号</th>
					<th width="25">使用状态</th>
					<th width="25">状态码</th>
					<th width="25">ICCID</th>
					<th width="25">IMSI</th>
					<th width="25">国家</th>
					<th width="25">运营商</th>
					<th width="25">归属地</th>
					<!-- <th width="25">当前位置</th> -->
					<th width="25">是否可用</th>
					<th width="25">更新时间</th>
					<th width="25">添加时间</th>
					<!-- <th width="80">操作</th> -->
				</tr>
			</thead>
			<tbody >
				 <c:forEach items="${list}" var="list">
				 <tr class="text-c">
					<td><input type="checkbox" name="" value=""></td>
					<td>${list.id }</td>
					<td>${list.cardno}</td>
					<td>${list.cardpoolno}</td>
					<td>${list.cardslotno}</td>
					  <c:choose>
					  	<c:when test="${list.status=='00'}"><td bgcolor='gray'>未插卡</td></c:when>
					  	<c:when test="${list.status=='55'}"><td bgcolor='yellow'>插卡未启动</td></c:when>
					  	<c:when test="${list.status=='AA'||list.status=='aa'}"><td bgcolor='green'>工作中</td></c:when>
					  	<c:when test="${list.status=='BB'||list.status=='bb'}"><td bgcolor='#98FB98'>已启用</td></c:when>
					  	<c:when test="${list.status=='FF'}"><td bgcolor='red'>异常</td></c:when>
					  </c:choose>
					<td>${list.status }</td>
					<td>${list.iccid }</td>
					<td>${list.imsi }</td>
					<td>${list.country }</td>
					<td>${list.operator }</td>
					<td>${list.province }</td>
					<td>
						<c:if test="${list.isable ==1 }">是</c:if>
						<c:if test="${list.isable ==0 }">否</c:if>
					</td>
					<td><fmt:formatDate value="${list.updatetime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><fmt:formatDate value="${list.addtime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>