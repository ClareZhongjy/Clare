<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Left</title>
<link href="<%=request.getContextPath()%>/static/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/static/js/jQuery/jquery-1.9.1.js"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap/js/bootstrap-paginator.min.js"></script>
</head>
<body>
<ul class="nav nav-tabs nav-stacked">
<li><a href="${pageContext.request.contextPath}/customer/enterCust.do" target="mainFrame">Page</a></li>
<li><a href="${pageContext.request.contextPath}/upload/preUpload.do" target="mainFrame">Upload</a></li>
<li><a href="#">3</a></li>
</ul>
</body>
</html>