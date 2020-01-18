<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Auto Management Application</title>
	<style>
     <%@ include file="css/style.css"%>
	</style>
</head>
<body>
	
		<h2 align="center">[Isil Example] Auto Management</h2>

    <div align="center">
        <table  border="1" cellpadding="5">
            <caption><h2>List of Autos</h2></caption>
            <tr>
                <th>ID</th>
                <th>modelo</th>
                <th>color</th>
                <th>marca</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="auto" items="${listAuto}">
                <tr>
                    <td><c:out value="${auto.id}" /></td>
                    <td><c:out value="${auto.modelo}" /></td>
                    <td><c:out value="${auto.color}" /></td>
                    <td><c:out value="${auto.marca}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${auto.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${auto.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
            <h3 align="center">
        	<a href="new">Add New Auto</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Autos</a>
        	
        </h3>
</body>
</html>
