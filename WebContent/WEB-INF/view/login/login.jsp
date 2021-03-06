<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>

<link
	href="<%=request.getContextPath()%>/static/js/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="<%=request.getContextPath()%>/static/js/jQuery/jquery-1.9.1.js"></script>
<script
	src="<%=request.getContextPath()%>/static/js/bootstrap/js/bootstrap.min.js"></script>

<link
	href="<%=request.getContextPath()%>/static/login/css/htmleaf-demo.css"></link>
<link
	href="<%=request.getContextPath()%>/static/login/css/mormalize.css"></link>


<style type="text/css">
form {
	display: block;
	margin-top: 0em;
}

.form-bg {
	
}

.form-horizontal {
	background: #fff;
	padding-bottom: 40px;
	border-radius: 15px;
	text-align: center;
}

.form-horizontal .heading {
	display: block;
	font-size: 35px;
	font-weight: 700;
	padding: 35px 0;
	border-bottom: 1px solid #f0f0f0;
	margin-bottom: 30px;
}

.form-horizontal .form-group {
	padding: 0 40px;
	margin: 0 0 25px 0;
	position: relative;
}

.form-horizontal .form-control {
	background: #f0f0f0;
	border: none;
	border-radius: 20px;
	box-shadow: none;
	padding: 0 20px 0 45px;
	height: 40px;
	transition: all 0.3s ease 0s;
}

.form-horizontal .form-control:focus {
	background: #e0e0e0;
	box-shadow: none;
	outline: 0 none;
}

.form-horizontal .form-group i {
	position: absolute;
	top: 12px;
	left: 60px;
	font-size: 17px;
	color: #c8c8c8;
	transition: all 0.5s ease 0s;
}

.form-horizontal .form-control:focus+i {
	color: #00b4ef;
}

.form-horizontal .fa-question-circle {
	display: inline-block;
	position: absolute;
	top: 12px;
	right: 60px;
	font-size: 20px;
	color: #808080;
	transition: all 0.5s ease 0s;
}

.form-horizontal .fa-question-circle:hover {
	color: #000;
}

.form-horizontal .main-checkbox {
	float: left;
	width: 20px;
	height: 20px;
	background: #11a3fc;
	border-radius: 50%;
	position: relative;
	margin: 5px 0 0 5px;
	border: 1px solid #11a3fc;
}

.form-horizontal .main-checkbox label {
	width: 20px;
	height: 20px;
	position: absolute;
	top: 0;
	left: 0;
	cursor: pointer;
}

.form-horizontal .main-checkbox label:after {
	content: "";
	width: 10px;
	height: 5px;
	position: absolute;
	top: 5px;
	left: 4px;
	border: 3px solid #fff;
	border-top: none;
	border-right: none;
	background: transparent;
	opacity: 0;
	-webkit-transform: rotate(-45deg);
	transform: rotate(-45deg);
}

.form-horizontal .main-checkbox input[type=checkbox] {
	visibility: hidden;
}

.form-horizontal .main-checkbox input[type=checkbox]:checked+label:after
	{
	opacity: 1;
}

.form-horizontal .text {
	float: left;
	margin-left: 7px;
	line-height: 20px;
	padding-top: 5px;
	text-transform: capitalize;
}

.form-horizontal .btn {
	float: right;
	font-size: 14px;
	color: #fff;
	background: #00b4ef;
	border-radius: 30px;
	padding: 10px 25px;
	border: none;
	text-transform: capitalize;
	transition: all 0.5s ease 0s;
}

@media only screen and (max-width: 479px) {
	.form-horizontal .form-group {
		padding: 0 25px;
	}
	.form-horizontal .form-group i {
		left: 45px;
	}
	.form-horizontal .btn {
		padding: 10px 20px;
	}
}

.center {
	position: relative;
	top: 50%;
}

@media ( min-width : 992px) {
	.col-md-offset-3 {
		margin-left: 25%;
	}
}

@media ( min-width : 992px) {
	.col-md-6 {
		width: 50%;
	}
}
</style>
</head>
<body background="<%=request.getContextPath()%>/static/pic/back.jpg">


	<div class="demo form-bg" style="padding: 20px 0; margin-top: 13%;">
		<div class="container">
			<div class="row center">
				<div class="col-md-offset-3 col-md-6">
					<c:url var="loginUrl" value="/login" />
					<form class="form-horizontal" action="${loginUrl }" method="post">
						<c:if test="${param.error != null}">
							<div class="alert alert-danger">
								<p>Invalid username and password.</p>
							</div>
						</c:if>
						<c:if test="${param.logout != null}">
							<div class="alert alert-success">
								<p>You have been logged out successfully.</p>
							</div>
						</c:if>
						<span class="heading">用户登录</span>
						<div class="form-group">
							<input type="text" name="userName" class="form-control"
								id="inputEmail3" placeholder="用户名或电子邮件"> <i
								class="fa fa-user"></i>
						</div>
						<div class="form-group help">
							<input type="password" name="password" class="form-control"
								id="inputPassword3" placeholder="密　码"> <i
								class="fa fa-lock"></i> <a href="#"
								class="fa fa-question-circle"></a>
						</div>
						
						<div class="form-group">
							<div class="checkbox">
								<label>
									<input type="checkbox" id="rememberme"name="remember-me" style="position: relative;left: 140px;">
									Remember Me
								</label>
							</div> 
						</div>
     
						
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<button type="submit" class="btn btn-default" style="position: relative;right: 104px;">登录</button>
						</form>
				</div>
				
			</div>
		</div>
	</div>
	

</body>
</html>