<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<style type="text/css">
.table {
    max-width: 40% !important;
}
</style>

<table>
<!--  path="name" corresponds to enitity in User.java -->
<form:form commandName="user">
<thead>
<tr><td align="center" colspan="2">REGISTER:</td></tr>
</thead>
	<tr>
	<td><label for="name">Name:	</label></td>
	
	<td><form:input path="name" /></td>
	</tr>
	
	<tr>
	<td><label for="email">Email:</label></td>
	
	<td><form:input path="email" /></td>
	</tr>
	
	<tr>
		<td><label for="password">Password:	</label></td>
	<td><form:password path="password" /></td>
	</tr>
</table>	
	<input type="submit" value="Register" /> 
	<c:if test="${param.insert_successful eq true }">Registration successful!</c:if>
</form:form>


<br><br>
<h1>Lorem Ipsum</h1>
<br>

<!-- Auto updates when form is sent -->
<center>
Already registered users.<br>
(To delete users login as admin)
<table class="table table-bordered table-hover table-condensed">
	<thead>
		<tr>
			<th bgcolor="grey">ID</th>
			<th bgcolor="grey">User</th>
			<th bgcolor="grey">Email</th>
			<th bgcolor="grey">Registration date</th>
			<th bgcolor="grey">Action</th>
		</tr>
<%-- items="${users}" from UserController.java --%>
	</thead>
	
	<c:if test="${!empty users}">

			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.id}</td>
						<td><spring:url value="/users/${user.id}.html" var="url" />
							<a href="${url}">${user.name}</a></td>
						<td>${user.email} <%-- <a href="<spring:url value:"/users/${user.id}.html" />">February: ${user.name} </a></td>--%>
						</td>
						<td>${user.registrationDate}</td>
						<td>
							<security:authorize access="hasRole('ROLE_ADMIN')">
							<spring:url value="/delete/${user.id}.html" var="url" />
							<a href="${url}">Delete</a>
							</security:authorize>
						</td>
					
					</tr>
				</c:forEach>

			</tbody>
		</c:if>
</table>
</center>
	