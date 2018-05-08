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
	<title>Javascript hidden input injection test</title>
	<script>
		/* <![CDATA[ */

		function addInput(id, name, value) {
			var elem = document.createElement("input");
			elem.type = "hidden";
			elem.name  = name;
			elem.value = value;
			document.getElementById(id).appendChild(elem);
		}

		function addInputAndSubmit(id, name, value) {
			addInput(id, name, value);
			document.getElementById(id).submit();
		}

		function doStuff(form, button) {
			var action = document.getElementById("action");
			action.value = button.name;
			form.submit();
		}

		/* ]]> */
	</script>
</head>
<body>

	<div> <a href="/">home</a>
		| <a href="formtest">formtest</a>
		| <a href="springformtest">springformtest</a>
		| <a href="csrfformtest">csrfformtest</a>
	</div>

	<% int id = 0; %>
	<c:set var="pager" value="<%= id %>" />
	<c:set var="formId" value='<%= "form" + id++ %>' />
	<csrf:form action="/formtest" method="post" id="${formId}">
		<p><a href="javascript:void(addInputAndSubmit('${formId}', 'pager', '${pager}'))">first</a></p>
	</csrf:form>

</body>
</html>
