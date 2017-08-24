<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload</title>
<link href="<%=request.getContextPath()%>/static/bootstrap3/css/bootstrap.min.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/static/js/jQuery/jquery-1.9.1.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap3/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/static/SweetAlert/js/sweet-alert.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/SweetAlert/css/sweet-alert.css">
<script type="text/javascript">
	
</script>
</head>
<body >
<div class="container-fluid">
<div style="border-bottom: solid 1px #ddd;">
	<h3>图片存储</h3>
	</div>
<form class="form-horizontal" action="uploadPic.do" method="post" enctype="multipart/form-data">  
	<div class="form-group">
			 <label  class="col-sm-2 control-label">图片</label>
			  <div class="col-sm-10">
			<input type="file" id="uploadPhoto" name="uploadPhoto1">  
			</div>
		</div>
		
	

		
<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
       <input type="submit" value="保存">
    </div>
  </div>
         
      
</form>  
</div>
</body>
</html>