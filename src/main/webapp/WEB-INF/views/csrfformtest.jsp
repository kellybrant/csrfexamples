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
	<title>OWASP CSRF token with Spring binding/validation test</title>
</head>
<body>

	<div> <a href="/">home</a>
		| <a href="formtest">formtest</a>
		| <a href="springformtest">springformtest</a>
		| <a href="csrfformtest">csrfformtest</a>
	</div>

	<c:set var="model" value="person" />
	<csrf:form action="/csrfformtest" method="post" id="person">
		<p><form:input  type="text" path="person.firstName" /></p>
		<p><form:input  type="text" path="person.lastName" /></p>
		<p><form:errors             path="person.*" /></p>
		<p><input type="submit" value="Submit" /></p>
	</csrf:form>

</body>
</html>
