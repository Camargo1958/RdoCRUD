<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RDO Page</title>
</head>
<body>
 <spring:url value="/rdo/add" var="addURL" />
 <a href="${addURL }">Add RDO</a>
 <h1>RDO List</h1>
 <table width="100%" border="1">
  	<tr>
   		<th>ID</th>
   		<th>Id do cliente</th>
   		<th>Id da obra</th>
   		<th>Data do relatorio</th>
   		<th>Hora do relatorio</th>
   		<th>Atividade executada</th>
   		<th>Status do relatorio</th>
   		<th colspan="2">Action</th>
  	</tr>
  	<c:forEach items="${listRdo }" var="rdo">
   		<tr>
    		<td>${rdo.id }</td>
    		<td>${rdo.id_cliente }</td>
    		<td>${rdo.id_obra }</td>
    		<td>${rdo.data_rel }</td>
    		<td>${rdo.hora_rel }</td>
    		<td>${rdo.atividade_executada }</td>
    		<td>${rdo.status_rel }</td>
    		<td>
				<spring:url value="/rdo/update/${rdo.id }" var="updateURL" />
     			<a href="${updateURL }">Update</a>
    		</td>
    		<td>
     			<spring:url value="/rdo/delete/${rdo.id }" var="deleteURL" />
     			<a href="${deleteURL }">Delete</a>
    		</td>
   		</tr>    
  	</c:forEach>
 </table>
</body>
</html>