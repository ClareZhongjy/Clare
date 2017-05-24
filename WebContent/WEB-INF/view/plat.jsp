<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>SpringMVC Demo API</title>
</head>
	<frameset id="index" rows="92,*" frameborder="yes" border="1" framespacing="0">
  		<frame id="topFrame" name="topFrame" scrolling="no" noresize="noresize" src="${pageContext.request.contextPath}/index/top">
    	<frameset id="main"  cols="20%,78%" frameborder="yes" border="1" framespacing="0">
	  		<frame name="leftFrame" scrolling="no" noresize="noresize" src="${pageContext.request.contextPath}/index/left">
	  		<frame name="mainFrame" scrolling="auto" noresize="noresize" src="${pageContext.request.contextPath}/index/welcome">
		</frameset>
	</frameset>
	<!--  
	<div class="container-fluid">
  <div class="row-fluid">
    <div class="span2">
     1
    </div>
    <div class="span10">
     2
    </div>
  </div>-->

</html>