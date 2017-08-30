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
	function doUploadPic(){
		
		var formData = new FormData($("#uploadForm")[0]);
		
	
		var pic = $("#uploadPhoto").val();

		if (pic == "") {
			swal("请上传图片");
			return false;
		} else {
			if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(pic)) {
				swal("图片类型必须是.gif,jpeg,jpg,png中的一种","", "error")
				return false;
			}
		}

		$.ajax({
			url : "uploadPic.do",
			type : "POST",
			data : formData,
			async : true,
			dataType : "text",
			contentType : false,
			processData : false,
			success : function(returnData) {
				if (returnData == 'success') {
					swal("上传成功", "", "success");
				}

			},
			error : function(returnData) {
				swal("上传失败！", "", "failed");
			}
		})
	}
	
	function downloadPic(){
		var url = "${pageContext.request.contextPath}/upload/preDownloadPic.do";
		window.location.href = url;
	}

</script>
</head>
<body >
<div class="container-fluid">
<div style="border-bottom: solid 1px #ddd;" class="form-group">
	<h3>图片存储</h3>
	</div>
	<div style="width:40%;">
<form id="uploadForm" class="form-horizontal" action="uploadPic.do" method="post" enctype="multipart/form-data">  
	<div class="form-group">
			 <label  class="col-sm-2 control-label">图片</label>
			  <div class="col-sm-10">
			<input class="form-control" type="file" id="uploadPhoto" name="pic">  
			<input type="hidden" name="username" value="${_USER.userName }">
			</div>
		</div>
		
	

		
<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
       <input class="btn btn-default" type="button" value="保存" onclick="doUploadPic();">
        <input class="btn btn-default" type="button" value="下载图片" onclick="downloadPic();">
    </div>
  </div>
  
  </form> 
  
 </div>   
</div>
</body>
</html>