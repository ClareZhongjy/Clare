<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Left</title>
<link href="<%=request.getContextPath()%>/static/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/static/js/jQuery/jquery-1.9.1.js"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<ul class="nav nav-tabs nav-stacked">
<li><a href="${pageContext.request.contextPath}/customer/enterCust.do" target="mainFrame">分页展示</a></li>
<li><a href="${pageContext.request.contextPath}/upload/preUpload.do" target="mainFrame">文件上传</a></li>
<li><a href="${pageContext.request.contextPath}/export/preExport.do" target="mainFrame">导出Excel</a></li>
<li><a href="#">3</a></li>
</ul>
</body>
</html>