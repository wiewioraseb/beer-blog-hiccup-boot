<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<head>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<tilesx:useAttribute name="current_active" scope="request"/>

<%-- Background image 
http://stackoverflow.com/questions/11163517/why-my-css-and-images-can-not-be-read-by-maven
http://stackoverflow.com/questions/28127843/creating-file-image-folder-directory-for-spring-mvc-and-maven-webapplication
 --%>
<style type="text/css">
body {
	background-image: url('http://crunchify.com/bg.png');
}

.container {
	background-color: #191919;
}

.navbar {
	display: block;
	box-sizing: border-box;
}

.navbar-brand {
	font-size: 22px !important;
	font-weight: bold;
}
</style>


<%-- https://developers.google.com/speed/libraries/devguide#jquery --%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<%-- Bootstrap --%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>



	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<%-- From bootstrap examples: http://getbootstrap.com/examples/starter-template/ --%>
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href='<spring:url value="/welcome.html" />'>Hiccup</a>
			</div>


			<!--  for security -->
			<!-- http://docs.spring.io/spring-security/site/docs/4.0.0.RELEASE/reference/htmlsingle/#el-common-built-in -->

			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="${current_active == 'users' ? 'active' : '' }"><a
						href='<spring:url value="/users.html" />'>Users</a></li>
					<li class="${current_active == 'register' ? 'active' : '' }"><a
						href='<spring:url value="/register.html" />'>Register</a></li>
					<security:authorize access="! isAuthenticated()">
						<li class="${current_active == 'log-in' ? 'active' : '' }"><a
							href='<spring:url value="/log-in.html" />'>Login</a></li>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<li><a href='<spring:url value="/logout" />'>Logout</a></li>
					</security:authorize>
					<li class="${current_active == 'contact' ? 'active' : '' }"><a
						href='<spring:url value="/contact.html" />'>Contact</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>


	<br><br><br>
	
	<%-- --%>
	<tiles:insertAttribute name="body" />
	
	<tiles:insertAttribute name="footer" />
	

</body>