<%@ page contentType="text/html; charset=UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/static/bootstrap3/css/bootstrap.min.css" rel="stylesheet">

<title>Top</title>

<script type="text/javascript">
function exitLogin(){
	
	 var url = "${pageContext.request.contextPath}/login/logout.do";
	 
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
	  	${_USER.cnName }
	  	<br>
	  	
	  	<a href="#" title="退出" style="margin-right: 0;float: right;" onclick="exitLogin();"> 
	  	<i class="glyphicon glyphicon-off" ></i> </a>
  	</span><br>
  	
  </div>
</div>

 




</body>
</html>