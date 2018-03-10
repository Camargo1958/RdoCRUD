<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RDO Form</title>
</head>
<body>
 <spring:url value="/rdo/save" var="saveURL" />
 <form:form modelAttribute="rdoForm" method="post" action="${saveURL }" >
  <form:hidden path="id"/>
  <table>
   <tr>
    <td>Id do cliente: </td>
    <td>
     <form:input path="id_cliente"/>
    </td>
   </tr>
   <tr>
    <td>Id da obra: </td>
    <td>
     <form:input path="id_obra"/>
    </td>
   </tr>
   <tr>
    <td>Data do relatorio: </td>
    <td>
     <form:input path="data_rel"/>
    </td>
   </tr>
   <tr>
    <td>Hora do relatorio: </td>
    <td>
     <form:input path="hora_rel"/>
    </td>
   </tr>
   <tr>
    <td>Atividade executada: </td>
    <td>
     <form:input path="atividade_executada"/>
    </td>
   </tr>
   <tr>
    <td>Status do relatorio: </td>
    <td>
     <form:input path="status_rel"/>
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