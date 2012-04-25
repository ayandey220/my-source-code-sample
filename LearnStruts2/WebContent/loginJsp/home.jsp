<%@page import="edu.learn.struts2.locale.StrutsLocale"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
By FreeMaker
ID: ${user.id} 
<br>
By OGNL (request) request parameter ['foo'] (request.getParameter()) <br>
<s:property value="%{#request.user.username}"/> | <s:property value="%{#request['user.username']}"/>
<br>
By OGNL (attribute) Access to PageContext if available, otherwise searches request/session/application respectively<br>
<s:property value="%{#attr.user.username}"/>
<br>
By Struts 
<s:property value="user.password"/>

<hr>
By JSP Expression : <%= StrutsLocale.getText("global.locale")%>
</body>
</html>