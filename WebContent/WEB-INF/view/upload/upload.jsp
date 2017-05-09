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

<script type="text/javascript">





	window.onload=function(){

		$('input[id=lefile]').change(function() {

		$('#photoCover').val($(this).val());
		});
		
		function duUpload(){
			var formData = new FormData($("#streamUpload"));
			$.ajax({
				url:"streamUpload.do",
				type:"POST",
				data:formData,
				async:false,
				success:function(returnData){
					alert("ok");
				},
				error:function(returnData){
					alert("failed");
				}
			});
		}
	
	}
	
	

</script>
</head>
<body>
<h3>upload files</h3>
<form  class="form-horizontal"  enctype="multipart/form-data"  id="streamUpload" >


 <div class="control-group">
 	<div class="controls">
	<span>Input Stream Upload</span>
	</div>
 <input id="lefile" type="file" name="file" style="display:none">
<div class="controls">
	<input id="photoCover" name ="ufile"class="input-large" type="text" style="height:30px;">
	<a class="btn" onclick="$('input[id=lefile]').click();">Browse</a>
</div>
 </div>
<div class="control-group">
    <div class="controls">
     
      <button type="button" class="btn" onClick="doUpload();">Upload</button>
    </div>
  </div>
 </form>
 
 
  
 
 

<script type="text/javascript">

</script>
</body>
</html>