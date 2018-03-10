<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Form</title>
</head>
<body>
 <spring:url value="/user/save" var="saveURL" />
 <form:form modelAttribute="userForm" method="post" action="${saveURL }" >
  <form:hidden path="id"/>
  <table>
   <tr>
    <td>User Name: </td>
    <td>
     <form:input path="user_name"/>
    </td>
   </tr>
   <tr>
    <td>Email: </td>
    <td>
     <form:input path="email"/>
    </td>
   </tr>
   <tr>
    <td>Password: </td>
    <td>
     <form:input path="password"/>
    </td>
   </tr>
   <tr>
    <td>Function: </td>
    <td>
     <form:input path="function"/>
    </td>
   </tr>
   <tr>
    <td>License Code: </td>
    <td>
     <form:input path="cust_lic"/>
    </td>
   </tr>
   <tr>
    <td>License Val: </td>
    <td>
     <form:input path="lic_val"/>
    </td>
   </tr>
   <tr>
    <td>Customer: </td>
    <td>
     <form:input path="cust_name"/>
    </td>
   </tr>
   <tr>
    <td></td>
    <td>
     <button type="submit">Save</button>
    </td>
   </tr>
  </table>
  
 </form:form>
 
</body>
</html>