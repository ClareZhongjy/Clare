<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload</title>
	<link href="<%=request.getContextPath()%>/static/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="<%=request.getContextPath()%>/static/js/jQuery/jquery-1.9.1.js"></script>
	<script src="<%=request.getContextPath()%>/static/js/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/SweetAlert/js/sweet-alert.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/SweetAlert/css/sweet-alert.css">
<script type="text/javascript">
	
</script>
</head>
<body>
	<h3>upload files</h3>
	<form class="form-horizontal" enctype="multipart/form-data"
		id="streamUpload">


		<div class="control-group">
			<div class="controls">
				<span>Input Stream Upload</span>
			</div>
			<input id="lefile" type="file" name="file" style="display: none">
			<div class="controls">
				<input id="photoCover" name="ufile" class="input-large" type="text"
					style="height: 30px;"> <a class="btn"
					onclick="$('input[id=lefile]').click();">Browse</a>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">

				<button type="button" class="btn btn-primary" onClick="doUpload()">Upload</button>
			</div>
		</div>
	</form>
<br>
	<form class="form-horizontal" enctype="multipart/form-data"
		id="multipartUpload">


		<div class="control-group">
			<div class="controls">
				<span>采用multipart提供的file.transfer方法上传文件</span>
			</div>
			<input id="lefile2" type="file" name="file" style="display: none">
			<div class="controls">
				<input id="photoCover2" name="ufile" class="input-large" type="text"
					style="height: 30px;"> <a class="btn"
					onclick="$('input[id=lefile2]').click();">Browse</a>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">

				<button type="button" class="btn btn-primary" onClick="doUpload2()">Upload</button>
			</div>
		</div>
	</form>
	
	<form class="form-horizontal" enctype="multipart/form-data"
		id="springMVCUpload">


		<div class="control-group">
			<div class="controls">
				<span>使用spring mvc提供的类的方法上传文件</span>
			</div>
			<input id="lefile3" type="file" name="file" style="display: none">
			<div class="controls">
				<input id="photoCover3" name="ufile" class="input-large" type="text"
					style="height: 30px;"> <a class="btn"
					onclick="$('input[id=lefile3]').click();">Browse</a>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">

				<button type="button" class="btn btn-primary" onClick="doUpload3()">Upload</button>
			</div>
		</div>
	</form>





	<script type="text/javascript">
		function doUpload() {
			var formData = new FormData($("#streamUpload")[0]);
			
			console.log(formData);
			$.ajax({
				url : "streamUpload.do",
				type : "POST",
				data : formData,
				async : true,
				dataType:"text",
				contentType: false,  
		        processData: false,
				success : function(returnData) {
					swal("上传成功！", "花费时间"+returnData, "success");
				},
				error : function(returnData) {
					swal("上传失败！", "", "failed")
				}
			});
		}
		
		function doUpload2() {
			var formData = new FormData($("#multipartUpload")[0]);
			
			console.log(formData);
			$.ajax({
				url : "multipartUpload.do",
				type : "POST",
				data : formData,
				async : true,
				dataType:"text",
				contentType: false,  
		        processData: false,
				success : function(returnData) {
						swal("上传成功！", "花费时间"+returnData, "success");		
				},
				error : function(returnData) {
					swal("上传失败！", "", "failed")
				}
			});
		}
		
		function doUpload3() {
			var formData = new FormData($("#springMVCUpload")[0]);
			
			console.log(formData);
			$.ajax({
				url : "springUpload.do",
				type : "POST",
				data : formData,
				async : true,
				dataType:"text",
				contentType: false,  
		        processData: false,
				success : function(returnData) {
						swal("上传成功！", "花费时间"+returnData, "success");		
				},
				error : function(returnData) {
					swal("上传失败！", "", "failed")
				}
			});
		}
		

		window.onload = function() {

			$('input[id=lefile]').change(function() {

				$('#photoCover').val($(this).val());
			});
			
			$('input[id=lefile2]').change(function() {

				$('#photoCover2').val($(this).val());
			});
			
			$('input[id=lefile3]').change(function() {

				$('#photoCover3').val($(this).val());
			});

		}
	</script>
</body>
</html>