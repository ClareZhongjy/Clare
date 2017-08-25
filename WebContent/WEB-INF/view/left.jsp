<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Left</title>
<link href="<%=request.getContextPath()%>/static/bootstrap3/css/bootstrap.min.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/static/js/jQuery/jquery-1.9.1.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap3/js/bootstrap.min.js"></script>
<script type="text/javascript">



	$(document).ready(function() {
		$('ul > li ').click(function(e) {
			//e.preventDefault();
			$('ul > li ').removeClass('active');
			$(this).addClass('active');
		});
	});
</script>
</head>
<body>
<ul class="nav nav-pills nav-stacked">
<li><a href="${pageContext.request.contextPath}/customer/enterCust.do" target="mainFrame"><i class="glyphicon glyphicon-th-list" ></i> 分页展示</a></li>
<li><a href="${pageContext.request.contextPath}/upload/preUpload.do" target="mainFrame"><i class="glyphicon glyphicon-open" ></i> 文件上传</a></li>
<li><a href="${pageContext.request.contextPath}/export/preExport.do" target="mainFrame"><i class="glyphicon glyphicon-log-in" ></i> 导出Excel</a></li>
<li><a href="${pageContext.request.contextPath}/upload/preUploadPic.do" target="mainFrame"><i class="glyphicon glyphicon-bookmark" ></i> 图片存储</a></li>
</ul>
</body>
</html>