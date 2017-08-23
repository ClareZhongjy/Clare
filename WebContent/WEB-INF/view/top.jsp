<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/static/bootstrap3/css/bootstrap.min.css" rel="stylesheet">

<title>Top</title>

<script type="text/javascript">
function exitLogin(){
	
	 var url = "${pageContext.request.contextPath}/login/loginOut.do?userName=${_USER.userName }";
	 
	 window.parent.location.href= url;
}

</script>
</head>
<body background="<%=request.getContextPath()%>/static/pic/banner.jpg">

<div class="row">
  <div class="col-md-11">
  	<h1 style="color:white;">SpringMVC Demo API </h1>
  </div>
  
  <div class="col-md-1">
  	<span style="float:right;color:white;margin-top: 8px;margin-right: 6px;">
	  	<i class="glyphicon glyphicon-user" ></i> 
	  	${_USER.userName }
	  	<br>
	  	<a href="#" title="退出" style="margin-right: 0;float: right;" onclick="exitLogin();">
	  	<i class="glyphicon glyphicon-off" ></i> </a>
  	</span><br>
  	
  </div>
</div>

 




</body>
</html>