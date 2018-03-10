<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Page</title>
</head>
<body>
 <spring:url value="/user/add" var="addURL" />
 <a href="${addURL }">Add User</a>
 <h1>User List</h1>
 <table width="100%" border="1">
  	<tr>
   		<th>ID</th>
   		<th>User Name</th>
   		<th>Email</th>
   		<th>Password</th>
   		<th>Function</th>
   		<th>License #</th>
   		<th>License Val</th>
   		<th>Customer</th>
   		<th colspan="2">Action</th>
  	</tr>
  	<c:forEach items="${listUser }" var="user">
   		<tr>
    		<td>${user.id }</td>
    		<td>${user.user_name }</td>
    		<td>${user.email }</td>
    		<td>${user.password }</td>
    		<td>${user.function }</td>
    		<td>${user.cust_lic }</td>
    		<td>${user.lic_val }</td>
    		<td>${user.cust_name }</td>
    		<td>
				<spring:url value="/user/update/${user.id }" var="updateURL" />
     			<a href="${updateURL }">Update</a>
    		</td>
    		<td>
     			<spring:url value="/user/delete/${user.id }" var="deleteURL" />
     			<a href="${deleteURL }">Delete</a>
    		</td>
   		</tr>    
  	</c:forEach>
 </table>
</body>
</html>