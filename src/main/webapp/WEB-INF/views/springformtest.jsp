<!DOCTYPE html>
<%@ page language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Spring binding/validation test</title>
</head>
<body>

	<div> <a href="/">home</a>
		| <a href="formtest">formtest</a>
		| <a href="springformtest">springformtest</a>
		| <a href="csrfformtest">csrfformtest</a>
	</div>

	<% int id = 0; %>
	<c:set var="formId" value='<%= "form" + id++ %>' />
	<form:form id="${formId}" method="POST" action="/springformtest" modelAttribute="data">
		<p><form:input path="create" type="text" /></p>
		<p><form:input path="recall" type="text" /></p>
		<p><form:input path="update" type="text" /></p>
		<p><form:input path="delete" type="text" /></p>
		<p><input type="submit" value="Submit" /></p>
	</form:form>

</body>
</html>
