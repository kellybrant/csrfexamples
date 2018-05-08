<!DOCTYPE html>
<%@ page language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="csrf"   uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
	<c:set var="model" value="data" />
	<csrf:form id="${formId}" method="POST" action="/springformtest">
		<p><form:input path="data.create" type="text" /></p>
		<p><form:input path="data.recall" type="text" /></p>
		<p><form:input path="data.update" type="text" /></p>
		<p><form:input path="data.delete" type="text" /></p>
		<p><input type="submit" value="Submit" /></p>
	</csrf:form>

</body>
</html>
