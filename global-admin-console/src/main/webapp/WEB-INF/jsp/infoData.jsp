<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Information Data</title>
<link href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/flatly/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
	<c:if test="${infoData ne null}">
		<table class="table table-striped table-hover">
		<thead>
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Details</td>
			</tr>
		</thead>
		<c:forEach items="${infoData}" var="data">
			<tr>
				<td>${data.id}</td>
				<td>${data.name}</td>
				<td>${data.details}</td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
</body>
</html>