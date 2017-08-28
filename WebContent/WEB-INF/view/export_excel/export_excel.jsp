<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导出Excel</title>

<link href="<%=request.getContextPath()%>/static/bootstrap3/css/bootstrap.min.css" rel="stylesheet">
	<script src="<%=request.getContextPath()%>/static/js/jQuery/jquery-1.9.1.js"></script>
	<script src="<%=request.getContextPath()%>/static/bootstrap3/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/SweetAlert/js/sweet-alert.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/SweetAlert/css/sweet-alert.css">


</head>
<body>

<h1>
</h1>
<form class="form-horizontal" enctype="multipart/form-data"
		id="excelExport" action="exportExcel.do">


		<div class="control-group">
			<div class="controls">
				<span>导出Excel</span>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">

				<button type="submit" class="btn btn-primary" >导出</button>
			</div>
		</div>
	</form>
</body>
</html>