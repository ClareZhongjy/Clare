<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传图像到DB</title>
<link href="<%=request.getContextPath()%>/static/bootstrap3/css/bootstrap.min.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/static/js/jQuery/jquery-1.9.1.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap3/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/static/SweetAlert/js/sweet-alert.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/SweetAlert/css/sweet-alert.css">
</head>
<body>
<div class="container-fluid">
<form id="registerForm" action="uploadPic.do" method="post" enctype="multipart/form-data">  
        上传头像 <input type="file" id="uploadPhoto" name="uploadPhoto1">  
     
        <p class="help-block">点击浏览上传您的照片(至少一张，最多可上传三张)</p>  
        <input type="submit" value="保存">
</form>  
</div>
</body>
</html>