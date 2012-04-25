<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Statement</title>
<s:head /> 
</head>
<body>
<s:form action="getStatement.action">
<s:textfield name="statement.username" label="Username" />
<s:password name="password" label="Password"/>
<s:submit />

<s:text name="statement.username" />
</s:form>
</body>
</html>