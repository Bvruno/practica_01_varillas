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

		<h2 align="center">Isil Example - Auto Management</h2>

    <div align="center">
		<c:if test="${auto != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${auto == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${auto != null}">
            			Edit Auto
            		</c:if>
            		<c:if test="${auto == null}">
            			Add New Auto
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${auto != null}">
        			<input type="hidden" name="id" value="<c:out value='${auto.id}' />" />
        		</c:if>            
            <tr>
                <th>Auto Modelo: </th>
                <td>
                	<input type="text" name="modelo" size="45"
                			value="<c:out value='${auto.modelo}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Auto Color: </th>
                <td>
                	<input type="text" name="color" size="45"
                			value="<c:out value='${auto.color}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Marca: </th>
                <td>
                	<input type="text" name="marca" size="15"
                			value="<c:out value='${auto.marca}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
        <h3 align="center">
        	<a href="new">Add New Auto</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Autos</a>
        	
        </h3>
</body>
</html>
